package com.rfchina.internet.mytestapp;

import android.os.Handler;
import android.os.Looper;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.activitystartmodel.FirstActivity;
import com.rfchina.internet.mytestapp.okhttpmodel.OkHttpTestActivity;
import com.rfchina.internet.mytestapp.wheelView.ShowWheelActivity;
import com.rfchina.internet.wheelviewsdk.datepicker.entry.Contacts;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by luoyican on 2018/7/11.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyTest {
    private static final String FINAL_CONTENT = "miss";

    @Rule
    public ActivityTestRule<FirstActivity> mActivityTestRule = new ActivityTestRule<>(FirstActivity.class);

    @Test
    public void sayHello() {
//        onView(withId(R.id.button));
//
//        onView(withText("Say hello!")).perform(click());

        onView(withId(R.id.button)).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView textView = (TextView) view;
                assertEquals("result:", "Button View", textView.getText().toString());
            }
        });
    }

    @Test
    public void testFun() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                ToastHelper.show("ddddddd");
            }
        });
    }

    @Test
    public void testClickFun() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpTestActivity okHttpTestActivity = new OkHttpTestActivity();
                        okHttpTestActivity.getR();
                    }
                }).start();
            }
        });
    }
}
