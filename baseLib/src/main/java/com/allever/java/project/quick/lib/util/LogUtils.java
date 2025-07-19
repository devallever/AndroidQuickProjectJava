package com.allever.java.project.quick.lib.util;

import android.util.Log;

public class LogUtils {
    private static final String TAG = "BaseLib-LogUtils";

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

}
