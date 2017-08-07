package com.rfchina.internet.mytestapp.okhttpmodel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.R;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;


/**
 * Created by luoyican on 2017/7/27.
 */

public class OkHttpTestActivity extends Activity {
    private TextView get;
    private TextView postJson;
    private TextView postForm;
    private TextView result;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_test);
        get = (TextView) findViewById(R.id.get);
        postJson = (TextView) findViewById(R.id.postJson);
        postForm = (TextView) findViewById(R.id.postForm);
        result = (TextView) findViewById(R.id.result);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //耗时任务绝对不能在主线程进行
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getRespone("http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html");
                    }
                }).start();
            }
        });

        postJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //耗时任务绝对不能在主线程进行
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url="";
                        String json = "";
                        postJsonRespone(url,json);
                    }
                }).start();
            }
        });

        postForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //耗时任务绝对不能在主线程进行
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url="http://smartshop.rfchina.com"+ "/api/sendSms";
                        postFormRespone(url);
                    }
                }).start();

            }
        });
    }

    private void getRespone(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                setText(new String(response.body().bytes(), "GB2312"));//要在返回的结果里用服务器的编码方式解码，不然乱码
            } else {
                setText(response + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postJsonRespone(String url, String json) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                setText(response.body().string());
            } else {
                setText(response + "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void postFormRespone(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder()
                .add("phone","13602453605")
                .add("type","3")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                setText(response.body().string());
            } else {
                setText(response + "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setText(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                result.setText(msg);
            }
        });
    }

}
