package com.nestozo.enriq.anihelp.extraviadosModule;

import com.nestozo.enriq.anihelp.common.pojo.Animal;
import com.nestozo.enriq.anihelp.extraviadosModule.events.MainEvent;
import com.nestozo.enriq.anihelp.extraviadosModule.model.InteractorImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PresenterImpl implements ExtraviadosContract.Presenter {
    private ExtraviadosContract.View view;
    private ExtraviadosContract.Interactor interactor;

    public PresenterImpl(ExtraviadosContract.View view) {
        this.view = view;
        this.interactor = new InteractorImpl();
    }

    @Override
    public void onCreate() {
        //registrar al presentador en el eventbus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        //dessuscribirnos a la lista de animales
        interactor.unsubscribeToAnimals();
    }

    @Override
    public void onResume() {
        interactor.subscribeToAnimals();
    }

    @Override
    public void onDestroy() {
        //anular registro al eventbus
        EventBus.getDefault().unregister(this);
        view = null;
    }

    @Override
    public void removeAnimal(Animal animal) {
        if(setProgress()){
            interactor.removeAnimal(animal);
        }else{

        }
    }

    private boolean setProgress() {
        if(view !=null){
            view.showProgress();
            return true;
        }
        return false;
    }

    @Subscribe
    @Override
    public void onEventListener(MainEvent mainEvent) {
        if(view !=null){
            view.hideProgress();
            switch (mainEvent.getTypeEvent()){
                case MainEvent.SUCCESS_ADD:
                    view.add(mainEvent.getAnimal());
                    break;
                case MainEvent.SUCCESS_UPDATE:
                    view.update(mainEvent.getAnimal());
                    break;
                case MainEvent.SUCCESS_REMOVE:
                    view.remove(mainEvent.getAnimal());
                    break;
                case MainEvent.ERROR_SERVER:
                    view.onShowError(mainEvent.getResMessage());
                    break;
                case MainEvent.ERROR_TO_REMOVE:
                    view.onShowError(mainEvent.getResMessage());
                    break;
            }
        }
    }

}
