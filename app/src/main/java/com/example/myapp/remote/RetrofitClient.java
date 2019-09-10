package com.example.myapp.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit getRetrofitClient(String url) {
        return new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                build();

    }
}