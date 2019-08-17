package com.nestozo.enriq.anihelp.common.pojo;

public class Cat extends Animal{
    private String raza="";


    public Cat(String raza) {
        this.raza = raza;
    }

    public Cat(String name, String color, String characterists, boolean state, String raza) {
        super(name, color, characterists, state);
        this.raza = raza;
    }
}
