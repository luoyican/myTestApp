package com.rfchina.internet.mytestapp.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.DimenUtil;
import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.mytestapp.ToastHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyican on 2018/3/6.
 */

public class ListviewActivity extends Activity {
    public final static String[] imageUrls = new String[]{
            "http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_3691.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_7315.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760663_7318.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_3454.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_5113.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_3305.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_7416.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_2946.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_1100.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760588_8297.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_2575.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_8906.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_2875.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_9517.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_7093.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_1352.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760548_2780.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1776.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1380.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_4944.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_5750.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760529_3289.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_7871.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_6063.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_6304.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_5081.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760498_7007.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_3128.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_6766.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_1358.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_3540.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760476_1240.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_7993.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760445_3283.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_8623.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_6822.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760422_2224.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760421_2824.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760420_2660.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760420_7188.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760419_4123.jpg",
    };
    RelativeLayout layout;
    ListView mListView;
    ImageView ivImg;

    private int lastX, lastY;    //保存手指点下的点的坐标
    final static int IMAGE_SIZE = 150;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        layout = (RelativeLayout) findViewById(R.id.layout);
        mListView = (ListView) findViewById(R.id.listview);
        ivImg = (ImageView) findViewById(R.id.img);
        ListviewAdapter listviewAdapter = new ListviewAdapter(initData());
        mListView.setAdapter(listviewAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListviewActivity.this, "点击的图片id是:" + position, Toast.LENGTH_LONG).show();
                ToastHelper.show("点击的图片id是:" + position);
            }
        });

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(IMAGE_SIZE, IMAGE_SIZE);
        ivImg.setLayoutParams(layoutParams);

        ivImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        //将点下的点的坐标保存
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        //计算出需要移动的距离
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;
                        //将移动距离加上，现在本身距离边框的位置
                        int left = view.getLeft() + dx;
                        int top = view.getTop() + dy;
                        //获取到layoutParams然后改变属性，在设置回去
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.height = IMAGE_SIZE;
                        layoutParams.width = IMAGE_SIZE;
                        if (left + IMAGE_SIZE > DimenUtil.getDisplayWidth(getApplicationContext())) {
                            layoutParams.leftMargin = DimenUtil.getDisplayWidth(getApplicationContext()) - IMAGE_SIZE;
                        } else {
                            if (left <= 0) {
                                layoutParams.leftMargin = 0;
                            } else {
                                layoutParams.leftMargin = left;
                            }
                        }
                        if (top + IMAGE_SIZE > DimenUtil.getDisplayHeight(getApplicationContext()) - DimenUtil.getStatusBarHeight(getApplicationContext())) {
                            layoutParams.topMargin = DimenUtil.getDisplayHeight(getApplicationContext()) - DimenUtil.getStatusBarHeight(getApplicationContext()) - IMAGE_SIZE;
                        } else {
                            if (top <= 0) {
                                layoutParams.topMargin = 0;
                            } else {
                                layoutParams.topMargin = top;
                            }
                        }
                        Log.e("messsss11", top + "     " + layoutParams.topMargin);
                        view.setLayoutParams(layoutParams);
                        //记录最后一次移动的位置
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        Log.e("messsss", lastX + "   " + lastY + "    " + ivImg.getWidth() + "   " + ivImg.getHeight());
                        Log.e("messsss", layoutParams.leftMargin + "     " + layoutParams.topMargin);
                        break;
                }
                //刷新界面
                layout.invalidate();
                return true;
            }
        });
    }

    private List<String> initData() {
        List<String> lists = new ArrayList<>();
        for (String url : imageUrls) {
            lists.add(url);
        }
        return lists;
    }
}
