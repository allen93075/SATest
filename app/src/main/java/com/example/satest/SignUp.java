package com.example.satest;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.RetrofitManager;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private EditText Username_input;
    private EditText Passward_input;
    private EditText Email_input;
    private EditText ConfirmPassword;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Username_input = (EditText) findViewById(R.id.Username_input);
        Passward_input = (EditText) findViewById(R.id.Password_input);
        Email_input = (EditText) findViewById(R.id.Email_input);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        register = (Button) findViewById(R.id.register);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api Api = RetrofitManager.getInstance().getAPI();
                Call<Records> call = Api.updateUser(Username_input, Email_input, Passward_input);
                call.enqueue(new Callback<Records>() {
                    @Override
                    public void onResponse(Call<Records> call, Response<Records> response) {
                    }
                    @Override
                    public void onFailure(Call<Records> call, Throwable t) {

                    }
                });



            }



        });
    }
}