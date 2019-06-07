package com.example.satest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Fragment.Front;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Field;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText Username_input;
    private EditText Passward_input;
    private Button Signup;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username_input = (EditText) findViewById(R.id.Username_input);
        Passward_input = (EditText) findViewById(R.id.Password_input);
        Signup = (Button) findViewById(R.id.Signup);


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });


        Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Front.class);
                startActivity(intent);
            }
        });

        //用Sign_UP button 測試
//        Button info = findViewById(R.id.Signup);
//        final TextView tv3 = findViewById(R.id.tv3);
//        final StringBuffer sb = new StringBuffer();
//        info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //從server撈資料回來處理
//                Api postApi = RetrofitManager.getClient().create(Api.class);
//                Call<Field> call = postApi.user();
//                call.enqueue(new Callback<Field>() {
//                    @Override
//                    public void onResponse(Call<Field> call, Response<Field> response) {
//                        String a = response.body().getUser_id(0);
//                        tv3.setText(a);
//                    }
//
//                    @Override
//                    public void onFailure(Call<Field> call, Throwable t) {
//                        tv3.setText("錯誤");
//                    }
//                });
//                postApi.user().enqueue(new Callback<Field>() {
//                    @Override
//                    public void onResponse(Call<Field> call, Response<Field> response) {
//
//                        tv3.setText(response.body().getUser_id(0));
//                    }
//
//                    @Override
//                    public void onFailure(Call<com.example.satest.Retrofit.Field> call, Throwable t) {
//                        tv3.setText("錯誤");
//
//                    }
//                });

                //tv3.setText(sb.toString()+"到底有沒有呢????");
//            }
//        });


    }
}
