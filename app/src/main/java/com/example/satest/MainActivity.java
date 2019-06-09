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
    private TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username_input = (EditText) findViewById(R.id.Username_input);
        Passward_input = (EditText) findViewById(R.id.Password_input);
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

                Api Api = RetrofitManager.getClient().create(Api.class);
                Call<Field> call = Api.user();
                call.enqueue(new Callback<Field>() {
                    @Override
                    public void onResponse(Call<Field> call, Response<Field> response) {
                        for (int i = 0; i < response.body().getRecords().length; i++) {
                            String user = response.body().getFields(i).getUsername();
                            String password = response.body().getFields(i).getPassword();
                            if(Username_input==null){
                                tv3.setText("Username is null");
                                break;
                            }
                            if(Passward_input==null){

                                tv3.setText("please enter password");
                                break;
                            }

                            if ( user.equals(Username_input.getText().toString()) ) {
                                if (password.equals(Passward_input.getText().toString())) {
                                    Intent intent = new Intent();
                                    intent.setClass(MainActivity.this, Front.class);
                                    startActivity(intent);
                                }
                                else {
                                    tv3.setText("Password incorrected");
                                    break;
                                }
                            } else {
                                tv3.setText("Username incorrected");
                                break;
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<Field> call, Throwable t) {

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
//                Api postApi = RetrofitManager.getClient().create(Api.class);
//                Call<Field> call = postApi.user();
//                call.enqueue(new Callback<Field>() {
//                    @Override
//                    public void onResponse(Call<Field> call, Response<Field> response) {
//                        String a = response.body().getFields(0).getAccount();
//                        tv3.setText(a);
//                    }
//
//                    @Override
//                    public void onFailure(Call<Field> call, Throwable t) {
//                        tv3.setText("錯誤");
//                    }
//                });
//            }
//        })
//        ;
    }
}
