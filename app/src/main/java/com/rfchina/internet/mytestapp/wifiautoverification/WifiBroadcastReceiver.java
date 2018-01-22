package com.rfchina.internet.mytestapp.wifiautoverification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.MyApplication;
import com.rfchina.internet.mytestapp.utils.http.OnResponseListener;

/**
 * Created by luoyican on 2018/1/22.
 */

public class WifiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MyApplication.mHandler.removeCallbacks(runnable);
        MyApplication.mHandler.postDelayed(runnable, 5000);
    }

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            connect();
        }
    };

    private static void connect() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networdInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networdInfo.isConnected()) {
            WifiManager wifiManage = (WifiManager) MyApplication.context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManage.getConnectionInfo();
            String ssid = wifiInfo.getSSID();
            if (ssid.contains("rf_35f")) {
                WifiUtil.connect(new OnResponseListener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("edeeeee", response);
                        if (response.contains("您已经成功登录") || response.contains("用户已登录")) {
                            WifiBroadcastReceiver.toast("成功认证");
                        } else {
                            WifiBroadcastReceiver.toast("rfwifi:" + response);
                        }
                    }

                    @Override
                    public void onErrorResponse(String content, String errorStr) {
                        Log.e("edeeeee", content);
                        WifiBroadcastReceiver.toast(content);
                        MyApplication.mHandler.removeCallbacks(runnable);
                        MyApplication.mHandler.postDelayed(runnable, 60000);
                    }
                });
            }
        }
    }

    private static void toast(final String msg) {
        MyApplication.mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyApplication.context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
