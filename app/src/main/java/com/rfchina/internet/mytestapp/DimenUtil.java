package com.rfchina.internet.mytestapp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by luoyican on 2017/7/10.
 */

public class DimenUtil {
    public static int dip2px(float dipValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, MyApplication.context.getResources().getDisplayMetrics()) + 0.5f);

    }
    public static int dip2px(Context context, float dipValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getDisplayWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getDisplayHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static int getDisplayDensityDpi(Context context) {
        return getDisplayMetrics(context).densityDpi;
    }

    private static int statusBarHeight = 0;

    public static int getStatusBarHeight(Context context) {
        if (statusBarHeight == 0) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            }
        }
        return statusBarHeight;

    }
}
