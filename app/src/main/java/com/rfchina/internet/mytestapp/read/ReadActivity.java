package com.rfchina.internet.mytestapp.read;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_test);
    }
}

//public class ReadActivity extends Activity implements View.OnClickListener, FlipperLayout.TouchListener {
//
//    private String text = "";
//    private int textLenght = 0;
//
//    private static final int COUNT = 400;
//
//    private int currentTopEndIndex = 0;
//
//    private int currentShowEndIndex = 0;
//
//    private int currentBottomEndIndex = 0;
//
//    private Handler handler = new Handler() {
//        public void handleMessage(android.os.Message msg) {
//            FlipperLayout rootLayout = (FlipperLayout) findViewById(R.id.container);
//            View recoverView = LayoutInflater.from(ReadActivity.this).inflate(R.layout.item_view_read, null);
//            View view1 = LayoutInflater.from(ReadActivity.this).inflate(R.layout.item_view_read, null);
//            View view2 = LayoutInflater.from(ReadActivity.this).inflate(R.layout.item_view_read, null);
//            rootLayout.initFlipperViews(ReadActivity.this, view2, view1, recoverView);
//
//            textLenght = text.length();
//
//            System.out.println("----textLenght----->" + textLenght);
//
//            TextView textView = (TextView) view1.findViewById(R.id.textview);
//            if (textLenght > COUNT) {
//                textView.setText(text.subSequence(0, COUNT));
//                textView = (TextView) view2.findViewById(R.id.textview);
//                if (textLenght > (COUNT << 1)) {
//                    textView.setText(text.subSequence(COUNT, COUNT * 2));
//                    currentShowEndIndex = COUNT;
//                    currentBottomEndIndex = COUNT << 1;
//                } else {
//                    textView.setText(text.subSequence(COUNT, textLenght));
//                    currentShowEndIndex = textLenght;
//                    currentBottomEndIndex = textLenght;
//                }
//            } else {
//                textView.setText(text.subSequence(0, textLenght));
//                currentShowEndIndex = textLenght;
//                currentBottomEndIndex = textLenght;
//            }
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_container);
//        new ReadingThread().start();
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public View createView(final int direction) {
//        String txt = "";
//        if (direction == FlipperLayout.TouchListener.MOVE_TO_LEFT) {
//            currentTopEndIndex = currentShowEndIndex;
//            final int nextIndex = currentBottomEndIndex + COUNT;
//            currentShowEndIndex = currentBottomEndIndex;
//            if (textLenght > nextIndex) {
//                txt = text.substring(currentBottomEndIndex, nextIndex);
//                currentBottomEndIndex = nextIndex;
//            } else {
//                txt = text.substring(currentBottomEndIndex, textLenght);
//                currentBottomEndIndex = textLenght;
//            }
//        } else {
//            currentBottomEndIndex = currentShowEndIndex;
//            currentShowEndIndex = currentTopEndIndex;
//            currentTopEndIndex = currentTopEndIndex - COUNT;
//            txt = text.substring(currentTopEndIndex - COUNT, currentTopEndIndex);
//        }
//
//        View view = LayoutInflater.from(this).inflate(R.layout.item_view_read, null);
//        TextView textView = (TextView) view.findViewById(R.id.textview);
//        textView.setText(txt);
//
//        System.out.println("-top->" + currentTopEndIndex + "-show->" + currentShowEndIndex + "--bottom-->" + currentBottomEndIndex);
//        return view;
//    }
//
//    @Override
//    public boolean whetherHasPreviousPage() {
//        return currentShowEndIndex > COUNT;
//    }
//
//    @Override
//    public boolean whetherHasNextPage() {
//        return currentShowEndIndex < textLenght;
//    }
//
//    @Override
//    public boolean currentIsFirstPage() {
//        boolean should = currentTopEndIndex > COUNT;
//        if (!should) {
//            currentBottomEndIndex = currentShowEndIndex;
//            currentShowEndIndex = currentTopEndIndex;
//            currentTopEndIndex = currentTopEndIndex - COUNT;
//        }
//        return should;
//    }
//
//    @Override
//    public boolean currentIsLastPage() {
//        boolean should = currentBottomEndIndex < textLenght;
//        if (!should) {
//            currentTopEndIndex = currentShowEndIndex;
//            final int nextIndex = currentBottomEndIndex + COUNT;
//            currentShowEndIndex = currentBottomEndIndex;
//            if (textLenght > nextIndex) {
//                currentBottomEndIndex = nextIndex;
//            } else {
//                currentBottomEndIndex = textLenght;
//            }
//        }
//        return should;
//    }
//
//    private class ReadingThread extends Thread {
//        public void run() {
//            AssetManager am = getAssets();
//            InputStream response;
//            try {
//                response = am.open("text.txt");
//                if (response != null) {
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    int i = -1;
//                    while ((i = response.read()) != -1) {
//                        baos.write(i);
//                    }
//                    text = new String(baos.toByteArray(), "UTF-8");
//                    baos.close();
//                    response.close();
//                    handler.sendEmptyMessage(0);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
