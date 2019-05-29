package com.example.satest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.satest.Fragment.Front;

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





    }
}
