package com.rfchina.internet.mytestapp.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/8/22.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void start(View view) {
        int[] a = {8, 4, 1, 6, 7, 4, 9, 6, 4};
        a = sort(a);
        for (int i = 0; i < a.length; i++) {
            Log.d("ssssss", a[i] + "");
        }
    }

    public void pause(View view) {
        view.setSelected(true);
    }

    public void cancel(View view) {
        view.setSelected(true);
    }

    private int[] sort(int[] a) {
        int[] oal = new int[0];
        int[] even = new int[0];
        int[] temp;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                temp = even;
                even = new int[temp.length + 1];
                System.arraycopy(temp, 0, even, 0, temp.length);
                even[even.length - 1] = a[i];
            } else {
                temp = oal;
                oal = new int[temp.length + 1];
                System.arraycopy(temp, 0, oal, 0, temp.length);
                oal[oal.length - 1] = a[i];
            }
        }
        System.arraycopy(oal, 0, a, 0, oal.length);
        System.arraycopy(even, 0, a, oal.length, even.length);
        return a;
    }

}
