package com.rfchina.internet.mytestapp.utils.http;

/**
 * Created by msi on 2016/3/3.
 */
public abstract class OnResponseListener<T> {
    public abstract void onResponse(T response);

    public abstract void onErrorResponse(String content, String errorStr);

}
