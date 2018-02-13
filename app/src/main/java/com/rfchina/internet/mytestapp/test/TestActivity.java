package com.rfchina.internet.mytestapp.test;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import com.rfchina.internet.mytestapp.MainActivity;
import com.rfchina.internet.mytestapp.MyApplication;
import com.rfchina.internet.mytestapp.R;

import java.net.HttpURLConnection;
import java.util.LinkedList;

/**
 * Created by luoyican on 2017/8/22.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void start(View view) {
        Notification mNotification = new NotificationCompat.Builder(this)
                .setSmallIcon(this.getApplicationInfo().icon)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(this, 1, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT))
                .setContentTitle("测试测试测试测试测试测试测试测试测试测试\n测试")//android不同品牌的手机有自己的通知栏效果，米坑就是只显示这个，双触点下滑才会显示style内容，别问我为什么会知道
                .setContentText("3dfddf\nreere\n坑爹\nrrrrrr\nrrg\nyj\nertff\nrbnhntg\nt\nt\nt\ntt\ntttd\nrrdg\ntyyrt\nretert")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("3dfddf\nreere\n坑爹\nrrrrrr\nrrg\nyj\nertff\nrbnhntg\nt\nt\nt\ntt\ntttd\nrrdg\ntyyrt\nretert")
                        .setBigContentTitle("测试测试测试测试测试测试测试测试测试测试\n测试"))
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, mNotification);
        InheritHelper.A a = new InheritHelper.A();
    }

    Runnable timeoutRun = new Runnable() {
        @Override
        public void run() {
            Log.e("TTTTTTTTT", "Timeout  222222");
        }
    };

    public void pause(View view) {
        view.setSelected(true);
//        InheritHelper.B b = new InheritHelper.B();
        Log.e("TTTTTTTTT", "Timeout 11111");
        //定时器 超时处理

        MyApplication.mHandler.removeCallbacks(timeoutRun);
        MyApplication.mHandler.postDelayed(timeoutRun, 3000);
    }

    public void cancel(View view) {
        view.setSelected(true);
        InheritHelper.C c = new InheritHelper.C();
    }

    private int[] sort(int[] a) {
        int[] oal = new int[0];
        int[] even = new int[0];
        int[] temp;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                temp = even;
                even = new int[temp.length + 1];
                System.arraycopy(temp, 0, even, 0, temp.length);
                even[even.length - 1] = a[i];
            } else {
                temp = oal;
                oal = new int[temp.length + 1];
                System.arraycopy(temp, 0, oal, 0, temp.length);
                oal[oal.length - 1] = a[i];
            }
        }
        System.arraycopy(oal, 0, a, 0, oal.length);
        System.arraycopy(even, 0, a, oal.length, even.length);
        return a;
    }

}
