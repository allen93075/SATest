package com.example.satest.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("User_")
    Call<User_data> index();

}
