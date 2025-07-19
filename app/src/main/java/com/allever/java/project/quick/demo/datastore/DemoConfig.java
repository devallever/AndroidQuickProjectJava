package com.allever.java.project.quick.demo.datastore;

import com.allever.java.project.quick.lib.datastore.StoreManager;

public class DemoConfig {
    public static final String KEY_COUNTER = "KEY_COUNTER";

    public static void updateCounter(int counter) {
        StoreManager.getIns().putInt(KEY_COUNTER, counter);
    }

    public static int getCounter(int defaultValue) {
        return StoreManager.getIns().getInt(KEY_COUNTER, defaultValue);
    }
}
