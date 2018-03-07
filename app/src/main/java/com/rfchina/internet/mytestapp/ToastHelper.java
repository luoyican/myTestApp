package com.rfchina.internet.mytestapp;

import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by luoyican on 2018/3/7.
 */

public class ToastHelper {
    static Toast mToast;

    public static void show(String msg) {
        if (TextUtils.isEmpty(msg)) return;
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.context, msg, Toast.LENGTH_LONG);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
