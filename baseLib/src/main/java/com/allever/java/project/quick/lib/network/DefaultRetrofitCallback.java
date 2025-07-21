package com.allever.java.project.quick.lib.network;


import com.allever.java.project.quick.lib.util.ThreadUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultRetrofitCallback<R> implements Callback<R> {
    private final NetworkCallback<R> callback;

    //construct
    public DefaultRetrofitCallback(NetworkCallback<R> callback) {
        this.callback = callback;
    }


    @Override
    public void onResponse(Call<R> call, Response<R> response) {
        ThreadUtils.runOnUiThread(() -> {
            if (callback != null) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }
        });
    }


    @Override
    public void onFailure(Call<R> call, Throwable t) {
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onFailure(t.getMessage());
                }
            }
        });
    }
}
