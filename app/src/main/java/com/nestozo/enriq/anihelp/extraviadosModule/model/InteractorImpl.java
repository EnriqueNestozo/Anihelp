package com.nestozo.enriq.anihelp.extraviadosModule.model;

import com.nestozo.enriq.anihelp.common.BasicErrorEventCallback;
import com.nestozo.enriq.anihelp.common.pojo.Animal;
import com.nestozo.enriq.anihelp.extraviadosModule.ExtraviadosContract;
import com.nestozo.enriq.anihelp.extraviadosModule.events.MainEvent;
import com.nestozo.enriq.anihelp.extraviadosModule.model.dataAccess.AnimalEventListener;

import org.greenrobot.eventbus.EventBus;

public class InteractorImpl implements ExtraviadosContract.Interactor {
    private RealtimeDatabase realtimeDatabase;


    public InteractorImpl() {
        realtimeDatabase = new RealtimeDatabase();
    }

    @Override
    public void subscribeToAnimals() {
        realtimeDatabase.subscribeToAnimals(new AnimalEventListener() {
            @Override
            public void onChildAdded(Animal animal) {
                post(animal, MainEvent.SUCCESS_ADD);
            }

            @Override
            public void onChildUpdated(Animal animal) {
                post(animal,MainEvent.SUCCESS_UPDATE);
            }

            @Override
            public void onChildRemoved(Animal animal) {
                post(animal,MainEvent.SUCCESS_REMOVE);
            }

            @Override
            public void onError(String errorMessage) {
                post(MainEvent.ERROR_SERVER, errorMessage);
            }
        });
    }

    @Override
    public void unsubscribeToAnimals() {
        realtimeDatabase.unsubscribeToAnimals();
    }

    @Override
    public void removeAnimal(Animal animal) {
        realtimeDatabase.removeAnimal(animal, new BasicErrorEventCallback() {
            @Override
            public void onSuccess() {
                post(MainEvent.SUCCESS_REMOVE);
            }

            @Override
            public void onError(int typeEvent, String message) {
                post(typeEvent,message);
            }
        });
    }

    private void post(int typeEvent){
        post(null,typeEvent,"Removido correctamente");
    }

    private void post(int typeEvent, String resMessage){
        post(null,typeEvent,resMessage);
    }

    private void post(Animal animal, int typeEvent){
        post(animal,typeEvent,"Actualizado correctamente");
    }

    private void post(Animal animal, int typeEvent, String resMesssage) {
        MainEvent event = new MainEvent();
        event.setAnimal(animal);
        event.setTypeEvent(typeEvent);
        event.setResMessage(resMesssage);
        EventBus.getDefault().post(event);
    }
}
