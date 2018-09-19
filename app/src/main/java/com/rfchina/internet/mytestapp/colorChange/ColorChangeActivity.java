package com.rfchina.internet.mytestapp.colorChange;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.rfchina.internet.mytestapp.R;

public class ColorChangeActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    private Bitmap bitmap;
    private ImageView imageview;
    private SeekBar hueBar, saturationBar, lumBar;

    private float mHue, mSaturation, mLum;
    private static int MAXVALUE = 255, MIDVALUE = 127;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_change);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_color_change);
        imageview = (ImageView) findViewById(R.id.imageview);
        hueBar = (SeekBar) findViewById(R.id.hueBar);
        saturationBar = (SeekBar) findViewById(R.id.saturationBar);
        lumBar = (SeekBar) findViewById(R.id.lumBar);

        hueBar.setOnSeekBarChangeListener(this);
        saturationBar.setOnSeekBarChangeListener(this);
        lumBar.setOnSeekBarChangeListener(this);

        hueBar.setMax(MAXVALUE);
        hueBar.setProgress(MIDVALUE);
        saturationBar.setMax(MAXVALUE);
        saturationBar.setProgress(MIDVALUE);
        lumBar.setMax(MAXVALUE);
        lumBar.setProgress(MIDVALUE);

        imageview.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekbar, int progress, boolean arg2) {
        switch (seekbar.getId()) {
            case R.id.hueBar:
                mHue = (progress - MIDVALUE) * 1.0F / MIDVALUE * 180;
                Log.d("ddddd", "mHue:" + mHue);
                break;
            case R.id.saturationBar:
                mSaturation = progress * 1.0F / MIDVALUE;
                break;
            case R.id.lumBar:
                mLum = progress * 1.0F / MIDVALUE;
                break;
        }
        imageview.setImageBitmap(BitmapHelper.handleImageLikePS(bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

}


