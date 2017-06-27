package com.rfchina.internet.mytestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.activitystartmodel.FirstActivity;
import com.rfchina.internet.mytestapp.cornerlayout.CornerActivity;
import com.rfchina.internet.mytestapp.wheelView.ShowWheelActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView txtCorner, txtStartMondel, txtWheelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorner = (TextView) findViewById(R.id.txtCorner);
        txtStartMondel = (TextView) findViewById(R.id.txtStartMondel);
        txtWheelView = (TextView) findViewById(R.id.txtWheelView);


        txtCorner.setOnClickListener(this);
        txtStartMondel.setOnClickListener(this);
        txtWheelView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtCorner:
                startActivity(new Intent(this, CornerActivity.class));
                break;
            case R.id.txtStartMondel:
                FirstActivity.entryActivity(this);
                break;
            case R.id.txtWheelView:
                startActivity(new Intent(this, ShowWheelActivity.class));
                break;
        }
    }
}
