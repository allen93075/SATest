package com.example.satest.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
    @GET("User?api_key=keycL5kGwKuZlYMdn")
    Call <Field> user();

    //@GET("Image?maxRecords=3&view=Grid%20view")
    //Call <List<Image>> image();


}
