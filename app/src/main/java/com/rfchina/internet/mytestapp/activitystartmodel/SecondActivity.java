package com.rfchina.internet.mytestapp.activitystartmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/6/22.
 */

public class SecondActivity extends FirstActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_model_second);
        Log.d("IPCHelper.testNum", "" + IPCHelper.testNum);
//        Log.d(TAG, "onCreate: ");
//        printName(TAG);
    }

    public void onClick(View view){
        FirstActivity.entryActivity(this);
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
        Intent intent = new Intent(context, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }


    @Override
    protected void printName(String s) {
//        this.printName(s);//内存溢出
//        super.printName(s);
        Log.d("DFDFDF",TAG);
    }
}
