package com.allever.java.project.quick.lib.network;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConfig {
    private static Builder builder;
    private static Retrofit retrofit;

    //private constructor
    private NetworkConfig() {}

    public static void init(Builder networkConfigBuilder) {
        builder = networkConfigBuilder;
        init();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    private static void init() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        for (Interceptor interceptor : builder.interceptors) {
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        okHttpClientBuilder.addInterceptor(new LoggerInterceptor());
        retrofit = new Retrofit.Builder()
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(builder.baseUrl).build();
    }

    public static  <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    //builder
    public static class Builder {
        private String baseUrl;
        private final List<Interceptor> interceptors = new ArrayList<>();

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            interceptors.add(interceptor);
            return this;
        }

//        public NetworkConfig build() {
//            return new NetworkConfig(this);
//        }
    }
}
