package com.rfchina.internet.mytestapp.wifiautoverification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2018/1/16.
 */

public class WifiAutoVerificationActivity extends Activity {
    private final static String defaultWifiName = "rf_35";
    private final static String defaultWifiPassword = "12345678";
    private final static String defaultUserName = "luoyican";
    private final static String defaultUserPassword = "1qazxsw2";

    private EditText edtWifiName;
    private EditText edtWifiPassword;
    private EditText edtUserName;
    private EditText edtUserPassword;
    private TextView txtConnect;
    private TextView txtWifiState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_auto_verification);

        edtWifiName = (EditText) findViewById(R.id.edtWifiName);
        edtWifiPassword = (EditText) findViewById(R.id.edtWifiPassword);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtUserPassword = (EditText) findViewById(R.id.edtUserPassword);
        txtWifiState = (TextView) findViewById(R.id.txtWifiState);
        txtConnect = (TextView) findViewById(R.id.txtConnect);

        txtConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WifiAutoVerificationActivity.this,"这是个界面是假的操作，实际上已经自动连接rf_35",Toast.LENGTH_LONG).show();
            }
        });
    }
}
