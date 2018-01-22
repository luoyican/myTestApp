package com.rfchina.internet.mytestapp;

import android.app.Application;
import android.os.Handler;

/**
 * Created by luoyican on 2018/1/22.
 */

public class MyApplication extends Application {
    public static Application context;
    public static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mHandler = new Handler();
    }
}
