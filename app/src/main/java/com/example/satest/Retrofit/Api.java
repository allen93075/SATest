package com.example.satest.Retrofit;

import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @GET("User?api_key=keycL5kGwKuZlYMdn")
    Call <Records> user();

    @GET("Image?api_key=keycL5kGwKuZlYMdn")
    Call <Records> image();

    @GET("Tags?api_key=keycL5kGwKuZlYMdn")
    Call <Records> tags();

    @FormUrlEncoded
    @POST("User")
    Call <Records> signup();

    @POST("User?api_key=keycL5kGwKuZlYMdn")
    Call<Records> Post(@Field("Username") String name, @Field("Email") String mail, @Field("Password") String password);

}
