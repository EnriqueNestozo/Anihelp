package com.nestozo.enriq.anihelp.common.callbacks;

import com.nestozo.enriq.anihelp.common.model.User;

public interface LoginCallbacks {
    void onSucces(User user);
    void onError(String message);
}
