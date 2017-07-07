package com.rfchina.internet.mytestapp.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/7/6.
 *
 *  Android 自定义view实现非标准圆形液柱水波纹循环动画
 *  即实现图片的循环滚动（图片需要首尾相连）
 */

public class WaveView extends View {
    private static final int WAVE_TRANS_SPEED = 4;

    private Bitmap dstBitmap;
    private Paint mPaint;
    private int viewWidth, viewHeight;
    private Rect dstRect, srcRect;//dstRect目标矩形，srcRect原图切割区域矩形
    private int mSpeed;
    private PaintFlagsDrawFilter mDrawFilter;

    private int currentPosition = 0;

    public WaveView(Context context) {
        super(context);
        init(context);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        initPaint();
        initBitmap();
        dstRect = new Rect();
        srcRect = new Rect();

        mSpeed = dip2px(context, WAVE_TRANS_SPEED);
        mDrawFilter = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, Paint.DITHER_FLAG);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                currentPosition += mSpeed;
                if (currentPosition >= dstBitmap.getWidth()) {
                    currentPosition = 0;
                }
                postInvalidate();
                postDelayed(this,30);
            }
        },300);//300是因为activity的默认跳转动画时间，需要先让activity已经初始化完再开始动画，不然会与activity的动画抢cpu，造成不顺畅的情况

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 从canvas层面去除锯齿
        canvas.setDrawFilter(mDrawFilter);
        canvas.drawColor(Color.TRANSPARENT);

        if (currentPosition + viewWidth <= dstBitmap.getWidth()) {//当前起点加view宽度未达到图片的末尾
            srcRect.set(currentPosition, 0, currentPosition + viewWidth, viewHeight);
            dstRect.set(0, 0, viewWidth, viewHeight);
            canvas.drawBitmap(dstBitmap, srcRect, dstRect, mPaint);
        } else {
            /**
             * 原理，取view宽的画板,先画图的最后部分，再画图的最前面部分，使之刚好沾满画板
             * 一定要注意理解drawBitmap方法的src,dst的意思
             * srcRect:是指draw的bitmap需要画的矩形部分； dstDraw 是指需要画在canvas画板上的矩形部分
             * 还要注意规律：src.r - src.l = dst.r - dst.l
             */
            Log.i("TAG","currentPosition "+currentPosition+"　\ndstBitmap.getWidth()"+dstBitmap.getWidth());
            //先画图的最后部分,
            srcRect.set(currentPosition, 0, dstBitmap.getWidth(), viewHeight);
            dstRect.set(0, 0, dstBitmap.getWidth() - currentPosition, viewHeight);
            canvas.drawBitmap(dstBitmap, srcRect, dstRect, mPaint);
            //再画图的最前面部分
            srcRect.set(0, 0, viewWidth + currentPosition - dstBitmap.getWidth(), viewHeight);
            dstRect.set(dstBitmap.getWidth() - currentPosition, 0, viewWidth, viewHeight);
            canvas.drawBitmap(dstBitmap, srcRect, dstRect, mPaint);
        }
    }

    // 初始化bitmap
    private void initBitmap() {
        dstBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.ww)).getBitmap();
    }

    // 初始化画笔paint
    private void initPaint() {
        mPaint = new Paint();
        // 防抖动
        mPaint.setDither(true);
        // 开启图像过滤
        mPaint.setFilterBitmap(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }


    public int dip2px(Context context, float dipValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, context.getResources().getDisplayMetrics()) + 0.5f);

    }

}
