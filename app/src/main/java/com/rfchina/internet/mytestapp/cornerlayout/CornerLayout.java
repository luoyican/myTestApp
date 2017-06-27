package com.rfchina.internet.mytestapp.cornerlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by luoyican on 2017/6/13.
 * 此布局为带圆角控件，圆角可以自设，在使用的时候一定要注意：
 * ！！！设置background，不然圆角无法生效！！！
 * ！！！设置background，不然圆角无法生效！！！
 * ！！！设置background，不然圆角无法生效！！！
 * <p>
 * google 出品过一个叫CardView的控件，可以很方便的设置圆角。但是这个在Android 5.0以下不兼容
 * <p>
 * 温馨提示：此布局不应该在listView，recycleview中使用，因为一直在重绘会影响滑动，有性能问题
 */

public class CornerLayout extends FrameLayout {

    public CornerLayout(Context context) {
        this(context, null);
        init();
    }

    public CornerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private final RectF roundRect = new RectF();
    private float rect_adius = 10;
    private final Paint maskPaint = new Paint();
    private final Paint zonePaint = new Paint();

    private void init() {
        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(Color.WHITE);
        //
        float density = getResources().getDisplayMetrics().density;
        rect_adius = rect_adius * density;
    }

    public void setCorner(float adius) {
        rect_adius = adius;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int w = getWidth();
        int h = getHeight();
        Log.i("TAG", w + "   " + h);
        roundRect.set(0, 0, w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.i("jjj", "jjj");
        canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawRoundRect(roundRect, rect_adius, rect_adius, zonePaint);
        canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
        super.draw(canvas);
        canvas.restore();
    }
}
