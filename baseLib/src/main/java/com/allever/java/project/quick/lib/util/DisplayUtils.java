package com.allever.java.project.quick.lib.util;

import android.content.Context;
import android.util.DisplayMetrics;


public class DisplayUtils {
    public static DisplayMetrics getDisplayMetrics(Context context)  {
        return context.getResources().getDisplayMetrics();
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }
}
