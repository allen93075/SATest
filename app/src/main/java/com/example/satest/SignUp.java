package com.example.satest;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private EditText Username_signup;
    private EditText Passward_signup;
    private EditText Email_input;
    private EditText ConfirmPassword;
    private Button register;
    private String a;
    private TextView tv4;
    public Records check;
    public boolean checkSignup = true;
    private String U;
    private String P;
    private String E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        Username_signup = (EditText) findViewById(R.id.Username_signup);
        Passward_signup = (EditText) findViewById(R.id.Password_signup);
        Email_input = (EditText) findViewById(R.id.Email_input);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        register = (Button) findViewById(R.id.register);
        tv4 = findViewById(R.id.tv4);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //拿資料庫資料
////                    Api Api2 = RetrofitManager.getInstance().getAPI();
////                    Call<Records> call2 = Api2.user();
////                    call2.enqueue(new Callback<Records>() {
////                        @Override
////                        public  void onResponse(Call<Records> call, Response<Records> response) {
////
////
////                        }
////                        @Override
////                        public void onFailure(Call<Records> call, Throwable t) {
////
////                        }
////                    });
//
//                //拿資料庫資料
//                Pattern pat =
//                        Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
//                //檢查註冊事項
//                if (Username_signup != null && Passward_signup != null && Email_input != null && ConfirmPassword != null) {

////                    for (int i = 0; i < check.getRecords().length; i++) {
////                        String user = check.getFields(i).getUsername();
////                        String email = check.getFields(i).getEmail();
//
////                        if (pat.matcher(U).find() == false && Username_signup.equals(user)) {
////                            tv4.setText("此用戶名已經存在");
////                            checkSignup = false;
////                            break;
////                        }
//
////                        if (email.equals(Email_input)) {
////
////                            tv4.setText("此信箱已經註冊");
////                            checkSignup = false;
////                            break;
////                        }
//
//                        if (pat.matcher(P).find() == false) {
//
//                            tv4.setText("密碼有不法字元");
//                            checkSignup = false;
////                            break;
//                        }
////                        if (!Passward_signup.equals(ConfirmPassword)) {
////                            tv4.setText("二次密碼輸入錯誤");
////                            checkSignup = false;
////                            break;
////                        }
////                    }
//                    //檢查註冊事項
//                } else {
//                    tv4.setText("請填完所有欄位");
//                }
                //是否能夠寫入
//                if (checkSignup == true) {
                //寫入註冊資料

                U = Username_signup.toString();
                P = Passward_signup.toString();
                E = Email_input.toString();
                Api Api = RetrofitManager.getInstance().getAPI();
                Call<Records> call = Api.Post(new Req(new User_data(Username_signup.toString(),Passward_signup.toString(), Email_input.toString())));

                call.enqueue(new Callback<Records>() {
                    @Override
                    public void onResponse(Call<Records> call, Response<Records> response) {


                    }

                    @Override
                    public void onFailure(Call<Records> call, Throwable t) {
                    }
                });
                //寫入註冊資料
//                }


            }


        });
    }

}