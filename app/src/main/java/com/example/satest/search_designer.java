package com.example.satest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.satest.Fragment.Front;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Field;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_designer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_designer);


    }
}
