package com.rfchina.internet.mytestapp.mqtt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;

import de.greenrobot.event.EventBus;

/**
 * Created by luoyican on 2018/1/12.
 */

public class MQTTActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_model_first);
        EventBus.getDefault().register(this);
        startService(new Intent(this, MQTTService.class));
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onClick(View view) {
        MQTTService.publish("我是好人233333");
    }

    public void onEvent(String mqttMessage) {
        Log.i(MQTTService.TAG, "get message:" + mqttMessage);
        Toast.makeText(this, mqttMessage, Toast.LENGTH_SHORT).show();
    }
}
