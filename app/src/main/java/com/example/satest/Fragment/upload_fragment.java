package com.example.satest.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Image_data;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.Records_image;
import com.example.satest.Retrofit.Req;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.Url;
import com.example.satest.Retrofit.picture_data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class upload_fragment extends Fragment implements View.OnClickListener{
    private Button upload;
    private Button lastpage;
    private EditText url;
    private EditText id;
    private String U;
    public View searchView;
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchView= inflater.inflate(R.layout.upload_fragment, container,false);
        upload= (Button) searchView.findViewById(R.id.upload);
        upload.setOnClickListener(this);
        return searchView;
    }
    @Override
    public void onClick(View v){
        Api api= RetrofitManager.getInstance().getAPI();
        U=url.getText().toString();
        Call<Records_image> call= api.Post(new Url(new Image_data(String U)));
        call.enqueue(new Callback<Records_image>() {
            @Override
            public void onResponse(Call<Records_image> call, Response<Records_image> response) {

            }

            @Override
            public void onFailure(Call<Records_image> call, Throwable t) {

            }
        });
    }



}
