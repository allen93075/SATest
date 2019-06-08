package com.example.satest.Retrofit;


import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private Api myapi;

    private static RetrofitManager manager = new RetrofitManager();
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitManager() {
        okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
                .build();
        myapi = retrofit.create(Api.class);
    }

    public static RetrofitManager getInstance() {
        return Holder.getInstance;
    }


    public Api getAPI() {
        return myapi;
    }

    private static class Holder {
        public static final RetrofitManager getInstance = new RetrofitManager();

    }


}
