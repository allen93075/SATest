package com.example.satest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.Req;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class SignUp extends AppCompatActivity {
    private EditText Username_input;
    private EditText email_input;
    private EditText password;
    private EditText confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username_input = findViewById(R.id.Username_input);
        email_input = findViewById(R.id.e_mail_input);
        password = findViewById(R.id.Password_input);
        confirmpassword = findViewById(R.id.ConfirmPassword);


        Api Api= RetrofitManager.getInstance().getAPI();
        Call<Records> call = Api.postInfor(new Req(new User_data()));
        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {

            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {

            }
        });











    }


}
