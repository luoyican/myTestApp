package com.rfchina.internet.mytestapp.activitystartmodel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.DimenUtil;
import com.rfchina.internet.mytestapp.R;

/**
 * Created by luoyican on 2018/4/2.
 */

public class ExpandTextView extends LinearLayout {
    public static final int DEFAULT_LINE_NUM = 3;
    public static final int DEFAULT_TEXT_SIZE = 14;

    private TextView txtMsg;
    private LinearLayout viewMore;
    private TextView txtMore;

    // TextView字体的颜色
    private int textColor;
    // TextView字体的大小 单位DP
    private int textSizeWithDP;
    // TextView默认显示行数
    private int maxLines;
    // TextView的文本内容
    private String texts;
    // initMaxHight 默认最大行数时的高度  realHeight 填充内容后真实高度
    private int initMaxHight, realHeight;
    // 是否展开
    private boolean isExpand = false;

    public ExpandTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int resouceId = attrs.getAttributeResourceValue(null, "textColor", 0);
        if (resouceId > 0) {
            textColor = context.getResources().getColor(resouceId);
        }
        int resouceId2 = attrs.getAttributeResourceValue(null, "texts", 0);
        if (resouceId2 > 0) {
            texts = context.getResources().getText(resouceId2).toString();//布局文件控件参数是通过引用资源文件形式定义 texts="@strings/msg"
        } else {
            texts = attrs.getAttributeValue(null, "texts");//布局文件控件参数直接定义  texts="文本"
        }
        textSizeWithDP = DimenUtil.dip2px(attrs.getAttributeIntValue(null, "textSizeWithDP", DEFAULT_TEXT_SIZE));
        maxLines = attrs.getAttributeIntValue(null, "maxLines", DEFAULT_LINE_NUM);
        initView();

    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        initData();
    }

    public void setTextSize(float textSizeDX) {
        this.textSizeWithDP = DimenUtil.dip2px(textSizeDX);
        initData();
    }

    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
        initData();
    }

    public void setText(String texts) {
        this.texts = texts;
        initData();
    }

    private void initView() {
        View view = View.inflate(getContext(), R.layout.widget_expand_textview, this);
        txtMsg = (TextView) view.findViewById(R.id.txtMsg);
        viewMore = (LinearLayout) view.findViewById(R.id.viewMore);
        txtMore = (TextView) view.findViewById(R.id.txtMore);

        txtMore.setOnClickListener(onClickLinster);
        initData();
    }

    private void initData() {
        txtMsg.setText(texts);
        txtMsg.setTextColor(textColor);
        txtMsg.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeWithDP);
        initMaxHight = maxLines * txtMsg.getLineHeight() + 8;//8  textView默认高度 px

        txtMsg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (txtMsg.getHeight() > 0) {
                    Log.e("hhhhhhhhhh5", "txtMsg.getHeight()= " + txtMsg.getHeight());
                    realHeight = txtMsg.getHeight();
                    txtMsg.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    if (realHeight <= initMaxHight) {
                        viewMore.setVisibility(GONE);
                    } else {
                        viewMore.setVisibility(VISIBLE);
                        txtMsg.setMaxLines(maxLines);
                        txtMsg.setEllipsize(TextUtils.TruncateAt.END);
                    }
                }
            }
        });
    }

    /**
     * 对TextView进行伸缩处理
     */
    private void toggleAnim(final boolean isExpand) {
        ValueAnimator animator = null;
        if (isExpand) {//设置view的最大高度，可能内容太多不直接显示完，当要展开时再显示

        }
        if (isExpand) {
            animator = ValueAnimator.ofInt(initMaxHight, realHeight);//展开
            txtMsg.setMaxHeight(Integer.MAX_VALUE);
        } else {
            animator = ValueAnimator.ofInt(realHeight, initMaxHight);//缩进
        }
        animator.setDuration(300);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (Integer) animation.getAnimatedValue();
                txtMsg.getLayoutParams().height = value;
                txtMsg.requestLayout();
            }
        });
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isExpand) {//设置view的最大高度，可能内容太多不直接显示完，当要展开时再显示
                    txtMsg.setMaxHeight(initMaxHight);
                    txtMsg.setMaxLines(maxLines);
                    txtMsg.setEllipsize(TextUtils.TruncateAt.END);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private OnClickListener onClickLinster = new OnClickListener() {
        @Override
        public void onClick(View v) {
            isExpand = !isExpand;
            toggleAnim(isExpand);
            txtMore.setSelected(isExpand);
        }
    };
}
