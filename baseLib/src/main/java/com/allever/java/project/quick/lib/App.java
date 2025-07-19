package com.allever.java.project.quick.lib;

import android.app.Application;
import android.content.Context;

import com.allever.java.project.quick.lib.swipeback.BGASwipeBackHelper;

public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        BGASwipeBackHelper.init(this, null);
    }


}
