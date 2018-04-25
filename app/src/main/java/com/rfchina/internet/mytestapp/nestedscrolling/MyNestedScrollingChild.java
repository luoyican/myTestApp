package com.rfchina.internet.mytestapp.nestedscrolling;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by luoyican on 2018/3/28.
 */

public class MyNestedScrollingChild extends LinearLayout implements NestedScrollingChild {
    private NestedScrollingChildHelper mScrollingChildHelper;

    public MyNestedScrollingChild(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }

    /**
     * 设置嵌套滑动是否可用
     *
     * @param enabled
     */
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        mScrollingChildHelper.setNestedScrollingEnabled(enabled);
    }

    /**
     * 嵌套滑动是否可用
     *
     * @return
     */
    @Override
    public boolean isNestedScrollingEnabled() {
        return super.isNestedScrollingEnabled();
    }

    /**
     * 开始嵌套滑动,
     *
     * @param axes 表示方向 有一下两种值
     *             ViewCompat.SCROLL_AXIS_HORIZONTAL 横向哈东
     *             ViewCompat.SCROLL_AXIS_VERTICAL 纵向滑动
     */
    @Override
    public boolean startNestedScroll(int axes) {
        return mScrollingChildHelper.startNestedScroll(axes);
    }

    /**
     * 停止嵌套滑动
     */
    @Override
    public void stopNestedScroll() {
        mScrollingChildHelper.stopNestedScroll();
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    /**
     * 是否有父View 支持 嵌套滑动,  会一层层的网上寻找父View
     *
     * @return
     */
    @Override
    public boolean hasNestedScrollingParent() {
        return mScrollingChildHelper.hasNestedScrollingParent();
    }

    /**
     * 在处理滑动之后 调用
     *
     * @param dxConsumed     x轴上 被消费的距离
     * @param dyConsumed     y轴上 被消费的距离
     * @param dxUnconsumed   x轴上 未被消费的距离
     * @param dyUnconsumed   y轴上 未被消费的距离
     * @param offsetInWindow view 的移动距离
     * @return
     */
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable @Size(value = 2) int[] offsetInWindow) {
        return mScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /**
     * 一般在滑动之前调用, 在ontouch 中计算出滑动距离, 然后 调用该方法, 就给支持的嵌套的父View 处理滑动事件
     *
     * @param dx             x 轴上滑动的距离, 相对于上一次事件, 不是相对于 down事件的 那个距离
     * @param dy             y 轴上滑动的距离
     * @param consumed       一个数组, 可以传 一个空的 数组,  表示 x 方向 或 y 方向的事件 是否有被消费
     * @param offsetInWindow 支持嵌套滑动到额父View 消费 滑动事件后 导致 本 View 的移动距离
     * @return 支持的嵌套的父View 是否处理了 滑动事件
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable @Size(value = 2) int[] consumed, @Nullable @Size(value = 2) int[] offsetInWindow) {
        return mScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    /**
     * @param velocityX x 轴上的滑动速度
     * @param velocityY y 轴上的滑动速度
     * @param consumed  是否被消费
     * @return
     */
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return mScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    /**
     * @param velocityX x 轴上的滑动速度
     * @param velocityY y 轴上的滑动速度
     * @return
     */
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return mScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}
