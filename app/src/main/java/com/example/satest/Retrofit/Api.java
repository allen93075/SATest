package com.example.satest.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @GET("User?api_key=keycL5kGwKuZlYMdn")
    Call <Records> user();

    @POST("User?api_key=keycL5kGwKuZlYMdn") // 用@Body表示要傳送Body資料
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Records> postInfor(@Body Req User_data);

    //@GET("Image?maxRecords=3&view=Grid%20view")
    //Call <List<Image>> image();


}
