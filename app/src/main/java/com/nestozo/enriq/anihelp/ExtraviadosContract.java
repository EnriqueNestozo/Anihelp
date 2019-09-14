package com.nestozo.enriq.anihelp;

import com.nestozo.enriq.anihelp.common.model.Animal;

public interface ExtraviadosContract {
    interface View{
        void showProgress();
        void hideProgress();
        void add(Animal animal);
        void update(Animal animal);
        void remove(Animal animal);
        void onShowError(String message);
    }

    interface Presenter{
        void onCreate();
        void onPause();
        void onResume();
        void onDestroy();
        void removeAnimal(Animal animal);
    }

    interface Interactor{
        void subscribeToAnimals();
        void unsubscribeToAnimals();
        void removeAnimal(Animal animal);
    }
}
