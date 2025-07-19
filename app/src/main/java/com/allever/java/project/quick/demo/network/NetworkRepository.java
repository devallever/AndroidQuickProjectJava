package com.allever.java.project.quick.demo.network;

import com.allever.java.project.quick.lib.network.DefaultRetrofitCallback;
import com.allever.java.project.quick.lib.network.NetworkCallback;
import com.allever.java.project.quick.lib.network.NetworkConfig;

public class NetworkRepository {
    //inner static class
    private static class SingletonHolder {
        private static final NetworkRepository INSTANCE = new NetworkRepository();
    }
    public static NetworkRepository getIns() {
        return SingletonHolder.INSTANCE;
    }

    private NetworkRepository() {
        mApiService = NetworkConfig.create(ApiService.class);
    }

    private ApiService mApiService;

    public void getNetworkData(NetworkCallback<BannerResponse> callback) {
        mApiService.getBanner().enqueue(new DefaultRetrofitCallback<>(callback));
    }
}
