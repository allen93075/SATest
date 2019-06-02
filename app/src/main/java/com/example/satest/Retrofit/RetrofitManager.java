package com.example.satest.Retrofit;

import android.graphics.Bitmap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager manager = new RetrofitManager();
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private RetrofitManager(){
        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static Retrofit getClient(){
        return manager.retrofit;
    }
}
