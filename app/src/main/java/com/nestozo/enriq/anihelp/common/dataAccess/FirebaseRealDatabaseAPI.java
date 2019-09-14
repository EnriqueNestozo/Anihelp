package com.nestozo.enriq.anihelp.common.dataAccess;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseRealDatabaseAPI {
    private static FirebaseRealDatabaseAPI INSTANCE = null;
    private DatabaseReference dbReference;

    private FirebaseRealDatabaseAPI(){
        dbReference = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseRealDatabaseAPI getInstance(){
        if (INSTANCE == null){
            INSTANCE = new FirebaseRealDatabaseAPI();
        }
        return INSTANCE;
    }

    //Referencias
    public DatabaseReference getDbReference(){
        return dbReference;
    }
}
