package com.nestozo.enriq.anihelp.common.model;

public class Dog extends Animal {
    public static final String RAZA = "raza";

    private String raza="";


    public Dog(String raza) {
        this.raza = raza;
    }

    public Dog(String name, String color, String characterists, boolean state, String raza) {
        super(name, color, characterists, state);
        this.raza = raza;
    }
}
