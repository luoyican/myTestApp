package com.rfchina.internet.mytestapp.permission;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/8/7.
 */

public class PermissionActivity extends Activity {
    private final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text);

        findViewById(R.id.txtBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以下运行时权限问题只在Google自己的原生Android有意义，在国产的定制系统真没什么意义，国产的做法最简便的就是把targetSDK设置为23以下
                if (Build.VERSION.SDK_INT >= 23) {
                    if (PermissionActivity.this.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(PermissionActivity.this,Manifest.permission.CALL_PHONE)) {
                            new AlertDialog.Builder(PermissionActivity.this)
                                    .setTitle("授权申请")
                                    .setMessage("打电话是危险操作，可能会造成财产损失，需要您的授权")
                                    .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            requestPermission();
                                        }
                                    })
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }else {
                            requestPermission();
                        }
                    } else {
                        call();
                    }
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CODE);
    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(PermissionActivity.this, "用户拒绝授权", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
}
