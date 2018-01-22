package com.rfchina.internet.mytestapp.utils.http;

import com.squareup.okhttp.Call;

/**
 * Created by msi on 2016/3/3.
 */
public class HttpCall {
    private Call Call;

    public com.squareup.okhttp.Call getCall() {
        return Call;
    }

    public void setCall(com.squareup.okhttp.Call call) {
        Call = call;
    }
}
