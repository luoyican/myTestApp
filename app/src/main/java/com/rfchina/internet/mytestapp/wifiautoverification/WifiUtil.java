package com.rfchina.internet.mytestapp.wifiautoverification;

import android.content.Context;

import com.rfchina.internet.mytestapp.MyApplication;
import com.rfchina.internet.mytestapp.utils.http.HttpManager;
import com.rfchina.internet.mytestapp.utils.http.OnResponseListener;

import java.util.HashMap;

/**
 * Created by luoyican on 2018/1/16.
 */

public class WifiUtil {
    private static final String url = "http://10.35.1.2:90/login";

    public static void connect(OnResponseListener onResponseListener) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uri", "MTAuMzUuMS4yOjkwL2xvZ2lu");
        hashMap.put("terminal", "pc");
        hashMap.put("login_type", "login");
        hashMap.put("check_passwd", "0");
        hashMap.put("show_tip", "block");
        hashMap.put("show_change_password", "none");
        hashMap.put("short_message", "none");
        hashMap.put("show_captcha", "none");
        hashMap.put("show_read", "block");
        hashMap.put("show_assure", "none");
        hashMap.put("page_language", "zh");
        hashMap.put("username", "luoyican");
        hashMap.put("assure_phone", "");
        hashMap.put("password1", "");
        hashMap.put("password", "%B9%BA%B1h%2F%FE%DD%7E");
        hashMap.put("new_password", "");
        hashMap.put("retype_newpassword", "");
        hashMap.put("captcha_value", "");
        hashMap.put("save_user", "1");
        hashMap.put("save_pass", "1");
        hashMap.put("read", "1");
        hashMap.put("wx_captcha", "");

        HttpManager.getInstance(MyApplication.context).postAysn(url, hashMap, onResponseListener, null);
    }
}
