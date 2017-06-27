package com.rfchina.internet.mytestapp.cornerlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.rfchina.internet.mytestapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyican on 2017/6/14.
 */

public class CornerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corner);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new CornerAdapter(initDatas()));

        ListView list2 = (ListView) findViewById(R.id.list2);
        list2.setAdapter(new CornerAdapter(initDatas()));

    }

    private List<String> initDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("this is item " + i);
        }
        return list;
    }
}
