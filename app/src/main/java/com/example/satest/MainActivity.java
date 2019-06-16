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
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText Username_input;
    private EditText Passward_input;
    private Button Signup;
    private Button Login;
    private TextView tv3;
    private Boolean a = false;
    private Boolean b;
    private Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


        Username_input = (EditText) findViewById(R.id.Username_signup);
        Passward_input = (EditText) findViewById(R.id.Password_signup);
        Signup = (Button) findViewById(R.id.Signup);
        tv3 = (TextView) findViewById(R.id.tv3);

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

                Api Api = RetrofitManager.getInstance().getAPI();
                Call<Records> call = Api.user();

                call.enqueue(new Callback<Records>() {
                    @Override
                    public void onResponse(Call<Records> call, Response<Records> response) {

                        for (int i = 0; i < response.body().getRecords().length; i++) {

                            String user = response.body().getFields(i).getUsername();
                            String password = response.body().getFields(i).getPassword();
                            if (Username_input == null) {
                                tv3.setText("Username is null");
                                break;
                            }
                            if (Passward_input == null) {

                                tv3.setText("please enter password");
                                break;
                            }
                            if(user == null){

                                tv3.setText("沒有USER資料");
                                break;
                            }

                            if(password == null){

                                tv3.append("+沒有password資料");
                                break;
                            }

                            if (user != null && user.equals(Username_input.getText().toString())) {

                                a = true;

                                if (password != null && password.equals(Passward_input.getText().toString())) {
                                    Intent intent = new Intent();
                                    intent.setClass(MainActivity.this, Front.class);
                                    startActivity(intent);
                                    break;
                                } else {
                                    b = false;
                                }
                            } else {
                            }

                            if(a ==true && b == false){
                                tv3.setText("Password incorrected");
                            }

                            if(a == false){

                                tv3.setText("Username incorrected");

                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<Records> call, Throwable t) {

                    }
                });


            }
        });

        //Sign_UP button 測試
//        Button info = findViewById(R.id.Signup);
//        final TextView tv3 = findViewById(R.id.tv3);
//        final StringBuffer sb = new StringBuffer();
//        info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //從server撈資料回來處理
//                Api Api = RetrofitManager.getInstance().getAPI();
//                Call<Records> call = Api.user();
//                call.enqueue(new Callback<Records>() {
//                    @Override
//                    public void onResponse(Call<Records> call, Response<Records> response) {
//                        response.body().getFields(0).getAccount();
//                        tv3.setText(response.body().getFields(0).getAccount());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Records> call, Throwable t) {
//                        tv3.setText("錯誤");
//                    }
//                });
//            }
//        })
//        ;


    }
}
