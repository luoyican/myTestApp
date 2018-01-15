package com.rfchina.internet.mytestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.rfchina.internet.mytestapp.activitystartmodel.FirstActivity;
import com.rfchina.internet.mytestapp.activitystartmodel.IPCHelper;
import com.rfchina.internet.mytestapp.aliRecognition.AliRecognitionActivity;
import com.rfchina.internet.mytestapp.cornerlayout.CornerActivity;
import com.rfchina.internet.mytestapp.loadLargeImage.LargeImagerLoadActivity;
import com.rfchina.internet.mytestapp.media.MediaActivity;
import com.rfchina.internet.mytestapp.mqtt.MQTTActivity;
import com.rfchina.internet.mytestapp.okhttpmodel.OkHttpTestActivity;
import com.rfchina.internet.mytestapp.permission.PermissionActivity;
import com.rfchina.internet.mytestapp.printer.PrinterActivity;
import com.rfchina.internet.mytestapp.richtext.RichTextActivity;
import com.rfchina.internet.mytestapp.service.ServiceActivity;
import com.rfchina.internet.mytestapp.test.TestActivity;
import com.rfchina.internet.mytestapp.wheelView.ShowWheelActivity;
import com.rfchina.internet.mytestapp.xfermode.XfermodeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;

    private List<Class> activities;
    private Class[] tmpAct = {TestActivity.class, CornerActivity.class, FirstActivity.class, ShowWheelActivity.class, XfermodeActivity.class,
            LargeImagerLoadActivity.class, OkHttpTestActivity.class, PrinterActivity.class, RichTextActivity.class, PermissionActivity.class,
            MediaActivity.class, ServiceActivity.class, AliRecognitionActivity.class,MQTTActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listActivity);
        listView.setAdapter(new MainActivityAdapter(init()));
        IPCHelper.testNum = 33;
        Log.d("IPCHelper.testNum", "" + IPCHelper.testNum);
    }

    private List<Class> init() {
        activities = new ArrayList<>();
        for (Class a : tmpAct) {
            activities.add(a);
        }
        return activities;
    }

}
