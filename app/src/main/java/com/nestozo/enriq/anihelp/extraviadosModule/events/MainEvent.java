package com.nestozo.enriq.anihelp.extraviadosModule.events;

import com.nestozo.enriq.anihelp.common.pojo.Animal;

public class MainEvent {
    public static final int SUCCESS_ADD = 0;
    public static final int SUCCESS_UPDATE = 1;
    public static final int SUCCESS_REMOVE = 2;
    public static final int ERROR_SERVER = 100;
    public static final int ERROR_TO_REMOVE = 101;

    private Animal animal;
    private int typeEvent;
    private String resMessage;

    public MainEvent() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }
}
