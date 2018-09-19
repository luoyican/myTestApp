package com.rfchina.internet.mytestapp.http.http;

public class RequestProvider {
    private static RequestProvider requestProvider;

    public static RequestProvider getInstance() {
        if (requestProvider == null) {
            requestProvider = new RequestProvider();
        }
        return requestProvider;
    }

}
