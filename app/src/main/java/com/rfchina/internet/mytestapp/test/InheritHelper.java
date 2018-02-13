package com.rfchina.internet.mytestapp.test;

import android.util.Log;

/**
 * Created by luoyican on 2018/1/29.
 */

public class InheritHelper {

    public static class A {
        A() {
            F1();
        }

        public void F1() {
            Log.e("TTTTTTT", "AF1");
            F2("AAAA");
        }

        public void F2(String s) {
            Log.e("TTTTTTT", "AF2" + s);
        }

    }

    public static class B extends A {
        @Override
        public void F1() {
            super.F1();
            Log.e("TTTTTTT", "BF1");
        }

        @Override
        public void F2(String s) {
            super.F2(s);
            Log.e("TTTTTTT", "BF2" + s);
        }
    }

    public static class C extends A {
        @Override
        public void F2(String s) {
            Log.e("TTTTTTT", "CF2" + s);
        }
    }
}
