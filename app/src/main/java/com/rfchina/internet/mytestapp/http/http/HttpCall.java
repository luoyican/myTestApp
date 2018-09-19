package com.rfchina.internet.mytestapp.http.http;

import com.squareup.okhttp.Call;

public class HttpCall {
    private Call Call;

    public com.squareup.okhttp.Call getCall() {
        return Call;
    }

    public void setCall(com.squareup.okhttp.Call call) {
        Call = call;
    }
}
