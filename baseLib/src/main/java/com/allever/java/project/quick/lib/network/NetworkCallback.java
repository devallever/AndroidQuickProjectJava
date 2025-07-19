package com.allever.java.project.quick.lib.network;


import com.allever.java.project.quick.lib.util.LogUtils;

public interface NetworkCallback<R> {
    void onSuccess(R data);

    default void onFailure(String msg) {
        LogUtils.d("Request fail: " + msg);
    }
}
