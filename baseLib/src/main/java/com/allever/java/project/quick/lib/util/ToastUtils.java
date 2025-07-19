package com.allever.java.project.quick.lib.util;

import android.widget.Toast;

import com.allever.java.project.quick.lib.App;

public class ToastUtils {

    //private construct
    private ToastUtils() {

    }

    public static void show(String msg) {
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();
    }
}
