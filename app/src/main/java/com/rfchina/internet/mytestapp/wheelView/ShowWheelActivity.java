package com.rfchina.internet.mytestapp.wheelView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.wheelviewsdk.datepicker.entry.Contacts;
import com.rfchina.internet.wheelviewsdk.datepicker.entry.OnWheelChoosedValueListener;
import com.rfchina.internet.wheelviewsdk.datepicker.entry.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by luoyican on 2017/6/23.
 */

public class ShowWheelActivity extends Activity {
    private static final String TAG = "ShowWheelActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_show);
    }

    public void onClick1(View view) {
        showDateDialog(Contacts.FLAG_DATE_PICKER_YEAR);
    }

    public void onClick1s(View view) {
        showDateDialog(Contacts.FLAG_MODE_DATE_PICKER_HOUR_AND_MINUTE_AND_SECOND);
    }

    public void onClick2(View view) {
        showDateDialog(Contacts.FLAG_DATE_PICKER_YEAR | Contacts.FLAG_DATE_PICKER_MONTH);
    }

    public void onClick3(View view) {
        showDateDialog(Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY);
    }

    public void onClick4(View view) {
        showDateDialog(Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY | Contacts.FLAG_DATE_PICKER_HOUR);
    }

    public void onClick5(View view) {
        showDateDialog(Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY | Contacts.FLAG_DATE_PICKER_HOUR | Contacts.FLAG_DATE_PICKER_MINUTE);
    }

    public void onClick6(View view) {
        showDateDialog(Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY_AND_HOUR_AND_MINUTE_AND_SECOND);
    }

    private void showDateDialog(int mod) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        String dstr = "2008-4-24 12:12:12";
        try {
            Date date = sdf.parse(dstr);
            Log.d(TAG, date.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Log.d(TAG, calendar.toString());
            if (mod == (Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY | Contacts.FLAG_DATE_PICKER_HOUR)) {
                new DatePickerDialog.Builder(this)
                        .setCallback(
                                new OnWheelChoosedValueListener() {
                                    @Override
                                    public void choosedValue(int year, int month, int day, int hour, int minute, int second) {
                                        Log.d(TAG, "year " + year + " month " + month + " day " + day + " hour " + hour + " minute " + minute + " second " + second);
                                    }
                                })
                        .setMaxDate(new Date())
                        .setMinDate(date)
                        .setCurDate(new Date())
                        .setMod(mod)
                        .setShowSize(8)
                        .setCyclic(true)
                        .setShowLabel(false)
                        .setBtnColor("#ff6060")
                        .build();
            } else
                new DatePickerDialog.Builder(this)
                        .setCallback(
                                new OnWheelChoosedValueListener() {
                                    @Override
                                    public void choosedValue(int year, int month, int day, int hour, int minute, int second) {
                                        Log.d(TAG, "year " + year + " month " + month + " day " + day + " hour " + hour + " minute " + minute + " second " + second);
                                    }
                                })
                        .setMaxDate(new Date())
                        .setMinDate(date)
                        .setCurDate(new Date())
                        .setMod(mod)
                        .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
