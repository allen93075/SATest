package com.example.satest;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.Records_image;
import com.example.satest.Retrofit.Req;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.satest.Fragment.Front;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.Req;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;
import com.example.satest.Retrofit.picture_data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main extends AppCompatActivity {
    //    private String[] imageUrls=new String[]{
//            "https://dl.airtable.com/.attachmentThumbnails/77571fc8a0d050f6356a61ecea99ce6e/b5a5b581",
//            "https://dl.airtable.com/.attachmentThumbnails/99bab9ac36ccec5a95a1823777c92735/7189cf45",
//            "https://dl.airtable.com/.attachmentThumbnails/41323421615d568c2b8bd9632791c47d/ce140dfc",
//            "https://dl.airtable.com/.attachmentThumbnails/3635dc09e2708059cc27db46acd62bc5/46e1f2b6"
//
//
//    };


    private picture_data[] picture;
    private String[] imageUrls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_pic);

        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records_image> call = Api.image();
        call.enqueue(new Callback<Records_image>() {

            @Override
            public void onResponse(Call<Records_image> call, Response<Records_image> response) {
                int m=0;
                for(int j=0; j<response.body().getRecords().length; j++){
                    m++;
                }
                imageUrls= new String[m];
                for (int i = 0; i < response.body().getRecords().length; i++) {
                    //將從AirTable讀取的資料放入Array itemsData，其中圖片資料是1個URL網址
                    picture = response.body().getFields(i).getImage();
                    //if (picture != null) imageUrl = picture[0].url;
                    if (picture != null)
                        imageUrls[i] =picture[0].getUrl();

                }
                ViewPager viewPager=findViewById(R.id.viewpager);
                ViewPagerAdapter adapter=new ViewPagerAdapter (getApplicationContext(), imageUrls);
                viewPager.setAdapter(adapter);


            }
            @Override
            public void onFailure(Call<Records_image> call, Throwable t) {

            }




        });


    }

}

