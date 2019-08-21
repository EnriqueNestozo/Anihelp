package com.nestozo.enriq.anihelp.extraviadosModule.model.dataAccess;

import com.nestozo.enriq.anihelp.common.pojo.Animal;

public interface AnimalEventListener {
    void onChildAdded(Animal animal);
    void onChildUpdated(Animal animal);
    void onChildRemoved(Animal animal);
    void onError(String errorMessage);
}
