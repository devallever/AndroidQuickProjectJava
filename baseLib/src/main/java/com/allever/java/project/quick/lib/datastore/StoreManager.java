package com.allever.java.project.quick.lib.datastore;

import com.allever.java.project.quick.lib.App;
import com.tencent.mmkv.MMKV;

public class StoreManager {

    private MMKV mmkv;

    public static StoreManager getIns() {
        return StoreManagerHolder.instance;
    }

    public MMKV getDefaultMMKV() {
        return mmkv;
    }

    //construct
    private StoreManager() {
        MMKV.initialize(App.context);
        mmkv = MMKV.defaultMMKV();
    }

    public void putString(String key, String value) {
        mmkv.putString(key, value);
    }

    public String getString(String key) {
        return mmkv.getString(key, "");
    }

    public void putInt(String key, int value) {
        mmkv.putInt(key, value);
    }

    public int getInt(String key, int defaultValue) {
        return mmkv.getInt(key, defaultValue);
    }

    public void putLong(String key, long value) {
        mmkv.putLong(key, value);
    }

    public long getLong(String key) {
        return mmkv.getLong(key, 0);
    }

    public void putFloat(String key, float value) {
        mmkv.putFloat(key, value);
    }

    public float getFloat(String key) {
        return mmkv.getFloat(key, 0);
    }

    public void putBoolean(String key, boolean value) {
        mmkv.putBoolean(key, value);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mmkv.getBoolean(key, defaultValue);
    }

    private static class StoreManagerHolder {
        private final static StoreManager instance = new StoreManager();
    }
}
