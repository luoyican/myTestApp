package com.rfchina.internet.mytestapp.nestedscrolling;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by luoyican on 2018/3/28.
 */

public class MyNestedScrollingParent extends LinearLayout implements android.support.v4.view.NestedScrollingParent {
    private NestedScrollingParentHelper mNestedScrollingParentHelper;

    public MyNestedScrollingParent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    /**
     * 回调开始滑动
     *
     * @param child            该父VIew 的子View
     * @param target           支持嵌套滑动的 VIew
     * @param nestedScrollAxes 滑动方向
     * @return 是否支持 嵌套滑动
     */
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        mNestedScrollingParentHelper.onStopNestedScroll(child);
    }

    /**
     * 这里 主要处理 dyUnconsumed dxUnconsumed 这两个值对应的数据
     *
     * @param target
     * @param dxConsumed
     * @param dyConsumed
     * @param dxUnconsumed
     * @param dyUnconsumed
     */
    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e("NNNNNNNNNNN1", "onNestedScroll target = " + target + " , dxConsumed = " + dxConsumed + " , dyConsumed = " + dyConsumed + " , dxUnconsumed = " + dxUnconsumed + " , dyUnconsumed = " + dyUnconsumed);
    }

    /**
     * 这里 传来了 x y 方向上的滑动距离
     * 并且 先与 子VIew  处理滑动,  并且 consumed  中可以设置相应的 除了的距离
     * 然后 子View  需要更具这感觉, 来处理自己滑动
     *
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        consumed[1] = dy;
        Log.d("NNNNNNNNNN2", "onNestedPreScroll dx = " + dx + " dy = " + dy);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
}

//              子view	                        父view
//        startNestedScroll
//
//       onStartNestedScroll、onNestedScrollAccepted
//        dispatchNestedPreScroll	    onNestedPreScroll
//        dispatchNestedScroll	        onNestedScroll
//        stopNestedScroll	            onStopNestedScroll