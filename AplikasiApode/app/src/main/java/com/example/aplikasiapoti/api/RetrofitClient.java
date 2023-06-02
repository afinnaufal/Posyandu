package com.example.aplikasiapoti.api;

import java.util.Collections;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {


    private static final String BASE_URL = "http://192.168.18.21/api/";

    private static Retrofit retrofit;



    private RetrofitClient() {

    }


    public static Retrofit getInstance() {



        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL).
                    addConverterFactory(JacksonConverterFactory.create()).

                    build();
        }
        return retrofit;
    }

}
