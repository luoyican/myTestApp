package com.rfchina.internet.mytestapp.loadLargeImage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luoyican on 2017/7/10.
 */

public class LargeImagerLoadActivity extends Activity {
    private LargeImageView largeImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larde_image_load);
        largeImageView = (LargeImageView) findViewById(R.id.largeImageView);

        try
        {
            InputStream inputStream = getAssets().open("bigpicture.jpg");
            largeImageView.setInputStream(inputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        largeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LargeImagerLoadActivity.this, "eeee", Toast.LENGTH_LONG).show();
            }
        });
    }
}
