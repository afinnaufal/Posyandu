package com.example.aplikasiapoti.api;

import com.example.aplikasiapoti.BayiResponse;
import com.example.aplikasiapoti.PostRequestApi;
import com.example.aplikasiapoti.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BayiServiceApi {


    @GET("all")
    Call<BayiResponse> getDatabayi();

    @POST("add")
    Call<PostResponse> add(@Body PostRequestApi requestApi);

}
