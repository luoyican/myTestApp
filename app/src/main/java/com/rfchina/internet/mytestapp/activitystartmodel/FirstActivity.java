package com.rfchina.internet.mytestapp.activitystartmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.rfinterface.RFInterface;

import java.math.BigInteger;

/**
 * Created by luoyican on 2017/6/22.
 */

public class FirstActivity extends Activity implements RFInterface {
    private static final String TAG = "FirstActivity";
    private String msg = "11112232富力东山新天地已退出全新楼盘，平层户型为89-148平四房，带装修均价3万，周围设施便利社区配置高档，服务全面富力东山新天地已退出全新楼盘，平层户型为89-148平四房，带装修均价3万，周围设施便利社区配置高档，服务全面;11112232富力东山新天地已退出全新楼盘，平层户型为89-148平四房，带装修均价3万，周围设施便利社区配置高档，服务全面富力东山新天地已退出全新楼盘，平层户型为89-148平四房，带装修均价3万，周围设施便利社区配置高档，服务全面\"";
    private ExpandTextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_model_first);
        Log.d(TAG, "onCreate: " + IPCHelper.testNum);
        Log.d("IPCHelper.testNum", "" + IPCHelper.testNum);
        this.printName(TAG);
        mTextView = (ExpandTextView) findViewById(R.id.txtBuildIntroduction);
//        this.RFN_LoginReqAndCallBackFunName("dd11111111");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    public void onClick(View view) {
      long b = 0b10000000000000000000000000000000;
        mTextView.setText(" " + b);
//        SecondActivity.entryActivity(this);
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
        Intent intent = new Intent(context, FirstActivity.class);
        context.startActivity(intent);
    }

    protected void printName(String s) {
        Log.d("DDDDDDDDDprintName", s);
        RFN_LoginReqAndCallBackFunName("dd11111111");
    }

    @Override
    public String RFN_CheckLogin() {
        return null;
    }

    @Override
    public void RFN_LoginReqAndCallBackFunName(String s) {
        Log.d("DDDDDDDDD", s);
        Log.d("DDDDDDDDD", "FirstActivity1111111111");
    }

    @Override
    public void RFN_SSOInfoAndCallBackFunName(String s, String s1) {

    }

    @Override
    public void RFN_CloseWebView() {

    }

    @Override
    public void RFN_WebShareWithDataAndCallBackFunName(String shareData, String jsFuncName) {

    }
}
