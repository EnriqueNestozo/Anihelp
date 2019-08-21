package com.nestozo.enriq.anihelp.common;

public interface BasicErrorEventCallback {
    void onSuccess();
    void onError(int typeEvent, String message);
}
