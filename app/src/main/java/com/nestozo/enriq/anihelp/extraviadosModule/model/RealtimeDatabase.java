package com.nestozo.enriq.anihelp.extraviadosModule.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.nestozo.enriq.anihelp.common.BasicErrorEventCallback;
import com.nestozo.enriq.anihelp.common.model.FirebaseRealDatabaseAPI;
import com.nestozo.enriq.anihelp.common.pojo.Animal;
import com.nestozo.enriq.anihelp.extraviadosModule.events.MainEvent;
import com.nestozo.enriq.anihelp.extraviadosModule.model.dataAccess.AnimalEventListener;

public class RealtimeDatabase {
    private static final String PATH_ANIMALS = "animals";
    private FirebaseRealDatabaseAPI firebaseRealDatabaseAPI;
    private ChildEventListener animalChildEventListener;


    public RealtimeDatabase(){
        firebaseRealDatabaseAPI = FirebaseRealDatabaseAPI.getInstance();
    }

    private DatabaseReference getAnimalReference(){
        return firebaseRealDatabaseAPI.getDbReference().child(PATH_ANIMALS);
    }

    public void subscribeToAnimals(AnimalEventListener listener){
        if(animalChildEventListener == null){
            animalChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    listener.onChildAdded(getProduct(dataSnapshot));
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    listener.onChildUpdated(getProduct(dataSnapshot));
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    listener.onChildRemoved(getProduct(dataSnapshot));
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    switch (databaseError.getCode()){
                        case DatabaseError.PERMISSION_DENIED:
                            listener.onError("Lo siento, no tienes permiso de ver el catalogo de animales extraviados");
                            break;
                        default:
                            listener.onError("Ocurrió un error en el servidor, intente más tarde");
                    }
                }
            };
        }
        getAnimalReference().addChildEventListener(animalChildEventListener);
    }

    private Animal getProduct(DataSnapshot dataSnapshot) {
        Animal animal = dataSnapshot.getValue(Animal.class);
        if(animal !=null){
            animal.setId(dataSnapshot.getKey());
        }
        return animal;
    }

    public void unsubscribeToAnimals(){
        if (animalChildEventListener != null){
            getAnimalReference().removeEventListener(animalChildEventListener);
        }
    }

    public void removeAnimal(Animal animal, BasicErrorEventCallback callback){
        getAnimalReference().child(animal.getId()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null){
                    callback.onSuccess();
                }else{
                    switch (databaseError.getCode()){
                        case DatabaseError.PERMISSION_DENIED:
                            callback.onError(MainEvent.ERROR_TO_REMOVE, "Usted no tiene permiso de eliminar el item");
                            break;
                        default:
                            callback.onError(MainEvent.ERROR_SERVER, "Ocurrió un error en el servidor, intente más tarde");

                    }
                }
            }
        });

    }

}
