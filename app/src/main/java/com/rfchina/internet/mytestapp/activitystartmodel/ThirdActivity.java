package com.rfchina.internet.mytestapp.activitystartmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/6/22.
 */

public class ThirdActivity extends FirstActivity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_model_first);
        Log.d(TAG, "onCreate: ");
//        this.RFN_LoginReqAndCallBackFunName("dd");
    }

    public void onClick(View view){
        SecondActivity.entryActivity(this);
    }

    @Override
    public void RFN_LoginReqAndCallBackFunName(String s) {
//        super.RFN_LoginReqAndCallBackFunName(s);
        Log.d("DDDDDDDDD", "ThirdActivityeeeeeee");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public static void entryActivity(Context context) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
    }
}
