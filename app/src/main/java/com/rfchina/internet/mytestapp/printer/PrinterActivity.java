package com.rfchina.internet.mytestapp.printer;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.rfchina.internet.mytestapp.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyican on 2017/7/31.
 */

public class PrinterActivity extends Activity {
    private static final String TAG = "PrinterActivity";
    // 粗略计算打印纸上每个字段占的长度
    private int wlname = 18;
    private int wlnum = 6;
    private int wlunit = 7;
    private int wlprice = 9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
            new NetPrint("192.168.18.95").execute();
    }

    /**
     * 网络打印机
     */
    class NetPrint extends AsyncTask<String, String, String> {
        private String ip;
        private final String PORT = "61093";//一般都是9100
        private NetPrinter printer;

        public NetPrint(String ip) {
            this.ip = ip;
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                printer = new NetPrinter();
                if (!TextUtils.isEmpty(PORT)) {
                    printer.Open(ip, Integer.parseInt(PORT));
                }
                if (printer.IFOpen) {
                    JSONArray ArrayItems = new JSONArray();
                    Log.d(TAG, ip + " 打印完成1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            if (printer.IFOpen) {
                Log.d(TAG, ip + " 打印完成2");
            } else {
                Log.d(TAG, ip + " 未能连接打印机");
            }
        }
    }
}
