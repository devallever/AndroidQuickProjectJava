package com.allever.java.project.quick;

import com.allever.java.project.quick.demo.network.NetworkRepository;
import com.allever.java.project.quick.lib.App;
import com.allever.java.project.quick.lib.network.LoggerrInterceptor;
import com.allever.java.project.quick.lib.network.NetworkConfig;

import okhttp3.logging.HttpLoggingInterceptor;

public class QuickApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkConfig.init(new NetworkConfig.Builder()
                .setBaseUrl("https://www.wanandroid.com/")
                .addInterceptor(new HttpLoggingInterceptor()));
    }
}
