package com.rfchina.internet.mytestapp.okhttpmodel;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.R;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


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
                        String url = "http://192.168.197.37/get_data.xml";
                        String json = "";
                        postJsonRespone(url, json);
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
                        String url = "http://smartshop.rfchina.com" + "/api/sendSms";
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
                String re = response.body().string();//只能用一次response。body()
//                parseXmlWithPull(re);
                parseXmlWithSAX(re);

            } else {
                setText(response + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postFormRespone(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder()
                .add("phone", "13602453605")
                .add("type", "3")
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
        } catch (Exception e) {
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

    private void parseXmlWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String result = "";
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("app".equals(nodeName)) {
                            Log.d("TAG", "id= " + id);
                            Log.d("TAG", "name= " + name);
                            Log.d("TAG", "version= " + version);
                            result += "id= " + id + " name= " + name + " version= " + version + "\n";
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
            setText(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXmlWithSAX(String xmlData){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            XmlContentHandler contentHandler = new XmlContentHandler();
            //将contentHandler实例设置到XMLReader中
            xmlReader.setContentHandler(contentHandler);
            //开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
            setText(contentHandler.getResult());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
