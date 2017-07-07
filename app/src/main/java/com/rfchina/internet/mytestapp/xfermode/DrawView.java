package com.rfchina.internet.mytestapp.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2017/7/4.
 */

public class DrawView extends FrameLayout {
    Rect mRect;
    Bitmap dst;
    Paint mPaint;
    Bitmap bmp_9;
    NinePatch np;

    public DrawView(@NonNull Context context) {
        super(context);
        init();
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //服务器端的点9图获取方式，（没试过，不知道效果怎样)
//        Bitmap bitmap = BitmapFactory.decodeStream(stream);
//        byte[] chunk = bitmap.getNinePatchChunk();
//        boolean result = NinePatch.isNinePatchChunk(chunk);
//        NinePatchDrawable patchy = new NinePatchDrawable(bitmap, chunk, new Rect(), null);
        //加载本地的.9图
        bmp_9 = BitmapFactory.decodeResource(getResources(), R.drawable.e);
        np = new NinePatch(bmp_9, bmp_9.getNinePatchChunk(), null);
        dst = BitmapFactory.decodeResource(getResources(), R.drawable.r);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }
    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayerAlpha(0, 0, mRect.width(), mRect.height(), 255, Canvas.ALL_SAVE_FLAG);
        super.dispatchDraw(canvas);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(dst, mRect, mRect, mPaint);
//        np.draw(canvas, mRect,mPaint);

//        canvas.save();
//        mPaint.setColor(Color.BLACK);
//        mPaint.setStyle(Paint.Style.FILL);
//        Path path2 = new Path();
//        path2.moveTo(20, 930);
//        path2.lineTo(930, 930);
//        path2.lineTo(930, 20);
//        path2.close();
//        canvas.drawPath(path2, mPaint);
//        canvas.restore();
        canvas.restore();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRect = new Rect(0, 0, w, h);
    }
}
