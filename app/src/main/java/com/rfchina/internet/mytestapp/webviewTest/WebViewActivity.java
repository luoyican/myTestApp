package com.rfchina.internet.mytestapp.webviewTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.mytestapp.ToastHelper;

import java.util.List;

/**
 * Created by luoyican on 2018/4/25.
 */

public class WebViewActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com/");
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                WebView.HitTestResult result = ((WebView) v).getHitTestResult();
                if (result != null) {
                    int type = result.getType();
                    if (type == WebView.HitTestResult.IMAGE_TYPE || type == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {
                        ToastHelper.show("fffffffffucckk");
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("eeeeeee", "" + keyCode + "    " + event.getKeyCode());
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK)
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * 多态、继承、封装
     * 0.向上转型 A a = new C(); 向下转型 B b = (B) a;
     * 1.当父类对象(A)引用变量(a2)引用子类对象(B)时，被引用对象(B)的类型决定了调用谁(B)的成员方法，引用变量类型(A)决定可调用的方法。如果子类(B)中没有覆盖该方法，那么会去父类(A)中寻找。
     * 2.继承链中对象方法的调用的优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
     * *
     * 1--A and A
     * 2--A and A
     * 3--A and D
     * 4--B and A
     * 5--B and A
     * 6--A and D
     * 7--B and B
     * 8--B and B
     * 9--A and D
     **/
    public void onClickBtn(View view) {
        // C->B->A
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
//        B bb = (B) a1;        //向下转型，不可以，因为a1不是 instanceof B ,不安全转型，所以不可以强转，会报ClassCastException
//        B bbb = (B) a2;       //向下转型，可以，因为a2 instanceof B ,所以可以强转，不会报ClassCastException
//        A a3 = c;             //向上转型，可以
//        B bbbb = (B) a3;      //向下转型，可以，因为a3 instanceof C  extends B,所以可以强转，不会报ClassCastException
//        A a4 = d;             //向上转型，不可以，因为D 与 A 不存在关系

//        System.out.println("1--" + a1.show(b));//A and A
//        System.out.println("2--" + a1.show(c));//A and A
        System.out.println("3--" + a1.show(d));//A and D
        System.out.println("4--" + a2.show(b) +" cc:"+(a2 instanceof B));//B and A
//        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }

    class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }

        public void s() {
        }
    }

    class B extends A {

        public String show(B obj) {
            return ("B and B");
        }

    }

    class C extends B {

    }

    class D {

    }

}
