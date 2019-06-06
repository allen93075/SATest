package com.example.satest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Fragment.Front;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.User_data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    private EditText Username_input;
    private EditText Passward_input;
    private Button Signup;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("User")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });



//        Signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, SignUp.class);
//                startActivity(intent);
//            }
//        });


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
        Button info = findViewById(R.id.Signup);
        final TextView tv3 = findViewById(R.id.tv3);
        final StringBuffer sb = new StringBuffer();
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //從server撈資料回來處理
                Api postApi = RetrofitManager.getClient().create(Api.class);
                postApi.user().enqueue(new Callback<List<User_data>>() {
                    @Override
                    public void onResponse(Call<List<User_data>> call, Response<List<User_data>> response) {

                        List<User_data> list = response.body();
//                        for (User_data p : list) {
//                            sb.append("OOOAAAAOOO");
//                            sb.append(list);
//                            sb.append("\n");
//                            sb.append("---------------------\n");
//                        }
                        sb.append(list);
                        tv3.setText(sb);
                    }

                    @Override
                    public void onFailure(Call<List<User_data>> call, Throwable t) {
                        tv3.setText("錯誤");

                    }
                });

                //tv3.setText(sb.toString()+"到底有沒有呢????");
            }
        });


    }

}
