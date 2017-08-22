package com.rfchina.internet.mytestapp.service;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.mytestapp.permission.PermissionActivity;

/**
 * Created by luoyican on 2017/8/14.
 */

public class ServiceActivity extends Activity {
    private final int PERMISSION_REQUEST_CODE = 1;
    private DownloadService.DownloadBinder mDownloadBinder;
    private EditText et;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        et = (EditText) findViewById(R.id.et);
        et.setText("http://192.168.197.37/timg.jpg");
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
        if (Build.VERSION.SDK_INT >= 23)
            if (ServiceActivity.this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ServiceActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
            }
    }

    public void start(View view) {
        if (mDownloadBinder == null) return;
        mDownloadBinder.startDownload(et.getText().toString());
    }

    public void pause(View view) {
        if (mDownloadBinder == null) return;
        mDownloadBinder.pauseDownload();
    }

    public void cancel(View view) {
        if (mDownloadBinder == null) return;
        mDownloadBinder.cancelDownload();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ServiceActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                } else {
                    Toast.makeText(ServiceActivity.this, "用户拒绝授权", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
