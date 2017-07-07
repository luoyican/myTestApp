package com.rfchina.internet.mytestapp.xfermode;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.mytestapp.cornerlayout.CornerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyican on 2017/6/29.
 */

public class XfermodeActivity extends Activity {
    DrawView insertView;
    WaveView wave;
    MinionsDraw minion;
    TextView txtBtn;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xfermode);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new CornerAdapter(initDatas()));
        insertView = (DrawView) findViewById(R.id.insertView);
        wave = (WaveView) findViewById(R.id.wave);
        minion = (MinionsDraw) findViewById(R.id.minion);
        txtBtn = (TextView) findViewById(R.id.txtBtn);


        txtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i % 3 == 0) {
                    setVisibility(View.VISIBLE, View.GONE, View.GONE);
                    txtBtn.setText("图片交集");
                    i++;
                } else if (i % 3 == 1) {
                    setVisibility(View.GONE, View.VISIBLE, View.GONE);
                    txtBtn.setText("小萌萌");
                    i++;
                } else {
                    setVisibility(View.GONE, View.GONE, View.VISIBLE);
                    txtBtn.setText("水波动图");
                    i++;
                }
            }
        });
    }

    private void setVisibility(int b1, int b2, int b3) {
        insertView.setVisibility(b1);
        minion.setVisibility(b2);
        wave.setVisibility(b3);
    }

    private List<String> initDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("this is item " + i);
        }
        return list;
    }
}
