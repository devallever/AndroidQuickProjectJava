package com.allever.java.project.quick.demo.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("banner/json")
    Call<BannerResponse> getBanner();

}
