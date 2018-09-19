package com.rfchina.internet.mytestapp.http.http;


public abstract class OnResponseListener<T> {
    public abstract void onResponse(T response);

    public abstract void onErrorResponse(String content, String errorStr);

    /**
     * 当请求需要登录时,默认自动弹出登陆页
     * @return
     */
    public boolean autoCallLoginActivityWhenNeedLogin() {
        return true;
    }
}
