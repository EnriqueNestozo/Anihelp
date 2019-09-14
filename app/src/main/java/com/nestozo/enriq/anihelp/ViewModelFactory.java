package com.nestozo.enriq.anihelp;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.nestozo.enriq.anihelp.ViewModels.ViewModelLogin;
import com.nestozo.enriq.anihelp.common.callbacks.LoginCallbacks;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private LoginCallbacks loginCallbacks;

    public ViewModelFactory(LoginCallbacks loginCallbacks){
        this.loginCallbacks = loginCallbacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ViewModelLogin(loginCallbacks);
    }
}
