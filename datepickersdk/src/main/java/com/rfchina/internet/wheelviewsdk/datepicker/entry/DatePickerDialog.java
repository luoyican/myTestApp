package com.rfchina.internet.wheelviewsdk.datepicker.entry;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rfchina.internet.wheelviewsdk.R;
import com.rfchina.internet.wheelviewsdk.datepicker.widget.OnWheelScrollListener;
import com.rfchina.internet.wheelviewsdk.datepicker.widget.WheelView;
import com.rfchina.internet.wheelviewsdk.datepicker.widget.adapter.NumericWheelAdapter;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by luoyican on 2017/6/23.
 */
public class DatePickerDialog {
    private final int TYPE_YEAR = 1, TYPE_MONTH = 2, TYPE_DAY = 3, TYPE_HOUR = 4, TYPE_MINUTE = 5, TYPE_SECOND = 6;
    private final int MAX_MONTH = 12, MIN_MONTH = 1, MIN_DAY = 1;
    private final int MAX_HOUR = 23, MIN_HOUR = 0, MAX_MINUTE = 59, MIN_MINUTE = 0, MAX_SECOND = 59, MIN_SECOND = 0;
    private int curYear;
    private String labelYear = "年";
    private int curMonth;
    private String labelMonth = "月";
    private int curDay;
    private String labelDay = "日";
    private int curHour;
    private String labelHour = "时";
    private int curMinute;
    private String labelMinute = "分";
    private int curSecond;
    private String labelSecond = "秒";
    private boolean isShowYear, isShowMonth, isShowDay, isShowHour, isShowMinute, isShowSecond, isAllWhellShow;
    private Calendar minCalendar, maxCalendar, curCalendar;
    private WheelView wheelDay;

    private Context context;
    private int showSize;
    private boolean isCyclic;
    private boolean isShowLabel;
    private OnWheelChoosedValueListener callback;
    private Date maxDate;
    private Date minDate;
    private Date curDate;
    private int mod;
    private String btnColor;

    /**
     * 初始化
     */
    private void initData() {
        if (!isShowLabel) {
            labelYear = labelMonth = labelDay = labelHour = labelMinute = labelSecond = "";
        }
        if (maxDate.getTime() < minDate.getTime()) {
            Date t = maxDate;
            maxDate = minDate;
            minDate = t;
        }
        minCalendar = date2Calendar(minDate);
        maxCalendar = date2Calendar(maxDate);
        curCalendar = date2Calendar(curDate);
        initCurrentValue(curCalendar);

        if ((mod & Contacts.FLAG_DATE_PICKER_YEAR) == Contacts.FLAG_DATE_PICKER_YEAR)
            isShowYear = true;
        if ((mod & Contacts.FLAG_DATE_PICKER_MONTH) == Contacts.FLAG_DATE_PICKER_MONTH)
            isShowMonth = true;
        if ((mod & Contacts.FLAG_DATE_PICKER_DAY) == Contacts.FLAG_DATE_PICKER_DAY)
            isShowDay = true;
        if ((mod & Contacts.FLAG_DATE_PICKER_HOUR) == Contacts.FLAG_DATE_PICKER_HOUR)
            isShowHour = true;
        if ((mod & Contacts.FLAG_DATE_PICKER_MINUTE) == Contacts.FLAG_DATE_PICKER_MINUTE)
            isShowMinute = true;
        if ((mod & Contacts.FLAG_DATE_PICKER_SECOND) == Contacts.FLAG_DATE_PICKER_SECOND)
            isShowSecond = true;
        if ((mod & Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY_AND_HOUR_AND_MINUTE_AND_SECOND) == Contacts.FLAG_MODE_DATE_PICKER_YEAR_AND_MONTH_AND_DAY_AND_HOUR_AND_MINUTE_AND_SECOND)
            isAllWhellShow = true;

        showChoiceTimeDialog(context);
    }

    /**
     * 初始化当前时间
     */
    private void initCurrentValue(Calendar curCalendar) {
        curYear = curCalendar.get(Calendar.YEAR);
        curMonth = curCalendar.get(Calendar.MONTH) + 1;
        curDay = curCalendar.get(Calendar.DAY_OF_MONTH);
        curHour = curCalendar.get(Calendar.HOUR_OF_DAY);
        curMinute = curCalendar.get(Calendar.MINUTE);
        curSecond = curCalendar.get(Calendar.SECOND);
    }

    /**
     * 时间选择框
     */
    private void showChoiceTimeDialog(final Context mContext) {
        final View view = View.inflate(mContext, R.layout.dialog_choice_time, null);
        TextView txtCancel = (TextView) view.findViewById(R.id.txtCancel);
        TextView txtConfirm = (TextView) view.findViewById(R.id.txtConfirm);
        LinearLayout viewWheel = (LinearLayout) view.findViewById(R.id.viewWheel);
        WheelView wheelYear = (WheelView) view.findViewById(R.id.wheelYear);
        WheelView wheelMonth = (WheelView) view.findViewById(R.id.wheelMonth);
        WheelView wheelDay = (WheelView) view.findViewById(R.id.wheelDay);
        WheelView wheelHour = (WheelView) view.findViewById(R.id.wheelHour);
        WheelView wheelMinute = (WheelView) view.findViewById(R.id.wheelMinute);
        WheelView wheelSecond = (WheelView) view.findViewById(R.id.wheelSecond);
        this.wheelDay = wheelDay;
        if (isAllWhellShow) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.5f);
            wheelYear.setLayoutParams(lp);
        }
        final Dialog dialog = new Dialog(mContext, R.style.dialog_style);
        txtConfirm.setTextColor(Color.parseColor(btnColor));
        txtCancel.setTextColor(Color.parseColor(btnColor));

        setWheelVisibility(wheelYear, isShowYear);
        setWheelVisibility(wheelMonth, isShowMonth);
        setWheelVisibility(wheelDay, isShowDay);
        setWheelVisibility(wheelHour, isShowHour);
        setWheelVisibility(wheelMinute, isShowMinute);
        setWheelVisibility(wheelSecond, isShowSecond);
        initDatePicker(mContext, wheelYear, maxCalendar.get(Calendar.YEAR), minCalendar.get(Calendar.YEAR), curYear, labelYear, TYPE_YEAR);
        initDatePicker(mContext, wheelMonth, MAX_MONTH, MIN_MONTH, curMonth, labelMonth, TYPE_MONTH);
        initDatePicker(mContext, wheelDay, getMonthDays(curYear, curMonth), MIN_DAY, curDay, labelDay, TYPE_DAY);
        initDatePicker(mContext, wheelHour, MAX_HOUR, MIN_HOUR, curHour, labelHour, TYPE_HOUR);
        initDatePicker(mContext, wheelMinute, MAX_MINUTE, MIN_MINUTE, curMinute, labelMinute, TYPE_MINUTE);
        initDatePicker(mContext, wheelSecond, MAX_SECOND, MIN_SECOND, curSecond, labelSecond, TYPE_SECOND);
        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        txtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.choosedValue(curYear, curMonth, curDay, curHour, curMinute, curSecond);
                dialog.dismiss();
            }
        });

        dialog.setContentView(view);
        //对话框弹出/消失动画效果
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim);
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, 0);
        int height = view.getMeasuredHeight();
        lp.width = width; // 宽度
        lp.height = height; // 高度
        dialogWindow.setAttributes(lp);
        dialog.show();
    }

    /**
     * 初始化时间滚轮
     */
    private void initDatePicker(final Context context, WheelView wheel, int maxValue, final int minValue, int curValue, String label, final int type) {
        wheel.setDrawShadows(true);
        NumericWheelAdapter numericWheelAdapter1 = new NumericWheelAdapter(context, minValue, maxValue);
        numericWheelAdapter1.setLabel(label);
        wheel.setViewAdapter(numericWheelAdapter1);
        wheel.setCyclic(isCyclic);//是否可循环滑动
        wheel.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(final WheelView wheel) {
                wheelDay.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setValue(context, type, wheel.getCurrentItem() + minValue);
                    }
                }, 0);
            }
        });

        wheel.setVisibleItems(showSize);
        wheel.setCurrentItem(curValue - minValue);
    }

    /**
     * 设置滚轮是否显示
     *
     * @parms view
     * @parms isShow
     */
    private void setWheelVisibility(View view, boolean isShow) {
        if (isShow) view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }

    /**
     * 滚轮滚动后重新赋当前值
     *
     * @parms context
     * @parms type 滚动轮名称
     * @parms value 选中的值
     */
    private void setValue(final Context context, int type, int value) {
        switch (type) {
            case TYPE_YEAR:
                curYear = value;
                reloadWheelDay(context);
                break;
            case TYPE_MONTH:
                curMonth = value;
                reloadWheelDay(context);
                break;
            case TYPE_DAY:
                curDay = value;
                break;
            case TYPE_HOUR:
                curHour = value;
                break;
            case TYPE_MINUTE:
                curMinute = value;
                break;
            case TYPE_SECOND:
                curSecond = value;
                break;
        }
    }

    /**
     * 重设天数滚轮
     *
     * @parms context
     */
    private void reloadWheelDay(Context context) {
        curDay = curDay > getMonthDays(curYear, curMonth) ? getMonthDays(curYear, curMonth) : curDay;
        initDatePicker(context, wheelDay, getMonthDays(curYear, curMonth), 1, curDay, labelDay, TYPE_DAY);
    }

    /**
     * date转calender获取年月日时分秒
     *
     * @parms date
     */
    private Calendar date2Calendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 通过年份和月份 得到当月的天数
     *
     * @param year
     * @param month
     * @return
     */
    private int getMonthDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    public static class Builder {
        private Context context;
        private int showSize = 5;
        private boolean isCyclic = false;
        private boolean isShowLabel = true;
        private OnWheelChoosedValueListener callback;
        private Date maxDate = new Date();
        private Date minDate= new Date();
        private Date curDate= new Date();
        private int mod;
        private String btnColor = "#41a3ff";


        public Builder(Context context) {
            this.context = context;
        }

        public Builder setShowSize(int showSize) {
            this.showSize = showSize;
            return this;
        }

        public Builder setCyclic(boolean cyclic) {
            isCyclic = cyclic;
            return this;
        }

        public Builder setShowLabel(boolean showLabel) {
            isShowLabel = showLabel;
            return this;
        }

        public Builder setCallback(OnWheelChoosedValueListener callback) {
            this.callback = callback;
            return this;
        }

        public Builder setMaxDate(Date maxDate) {
            this.maxDate = maxDate;
            return this;
        }

        public Builder setMinDate(Date minDate) {
            this.minDate = minDate;
            return this;
        }

        public Builder setCurDate(Date curDate) {
            this.curDate = curDate;
            return this;
        }

        public Builder setMod(int mod) {
            this.mod = mod;
            return this;
        }

        public Builder setBtnColor(String btnColor){
            this.btnColor = btnColor;
            return this;
        }

        public DatePickerDialog build() {
            return new DatePickerDialog(this);
        }
    }

    private DatePickerDialog(Builder builder) {
        context = builder.context;
        showSize = builder.showSize;
        isCyclic = builder.isCyclic;
        isShowLabel = builder.isShowLabel;
        callback = builder.callback;
        minDate = builder.minDate;
        maxDate = builder.maxDate;
        curDate = builder.curDate;
        mod = builder.mod;
        btnColor = builder.btnColor;
        initData();
    }
}
