package com.nestozo.enriq.anihelp.common.pojo;

import com.google.firebase.database.Exclude;

public abstract class Animal {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String COLOR = "color";
    public static final String CHARACTERISTICS = "characteristics";
    public static final String STATE = "state";
    public static final String LASTLOCATION = "lastLocation";

    @Exclude
    private String id="";
    private String name ="";
    private String color="";
    private String characterists="";
    private boolean state = false;
    private String lastLocation = "";


    public Animal() {

    }

    public Animal(String name, String color, String characterists, boolean state){
        this.name = name;
        this.color = color;
        this.characterists = characterists;
        this.state = state;
    }

    @Exclude
    public String getId() {
        return id;
    }

    @Exclude
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCharacterists() {
        return characterists;
    }

    public void setCharacterists(String characterists) {
        this.characterists = characterists;
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }
}
