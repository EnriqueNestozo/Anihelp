package com.nestozo.enriq.anihelp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nestozo.enriq.anihelp.common.callbacks.LoginCallbacks;
import com.nestozo.enriq.anihelp.common.model.User;
import com.nestozo.enriq.anihelp.common.repositories.UserRepository;

public class ViewModelLogin extends ViewModel {
    private MutableLiveData<User> user;
    UserRepository userRepository;
    LoginCallbacks loginCallbacks;

    public ViewModelLogin(LoginCallbacks loginCallbacks){
        user = new MutableLiveData<>();
        userRepository = new UserRepository(this);
        this.loginCallbacks = loginCallbacks;
    }

    public LiveData<User> getUser(){
        return user;
    }

    public void setUser(User loginUser){
        this.user.setValue(loginUser);
        if(loginUser.isValidData()!=""){
            loginCallbacks.onError(loginUser.isValidData());
        }else{
            userRepository.signIn(loginUser);
        }
    }

    public void loadMainView(){
        loginCallbacks.onSucces(user.getValue());
    }

    public void loadErrorMessage(String message){
        loginCallbacks.onError(message);
    }
}
