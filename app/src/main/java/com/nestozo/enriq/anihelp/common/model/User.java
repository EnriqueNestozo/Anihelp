package com.nestozo.enriq.anihelp.common.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User {
    private String email="";
    private String password="";
    private String photo="";

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String isValidData(){
        String message="";
        if(TextUtils.isEmpty(getEmail()) || TextUtils.isEmpty(getPassword())){
            message = "Campos vacíos";
        }else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            message = "Correo incorrecto";
        }
        return message;
    }
}
