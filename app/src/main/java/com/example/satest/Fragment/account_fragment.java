package com.example.satest.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class account_fragment extends Fragment {
    private TextView user_Name;
    private Button intro_edit;
    private Button pic_edit;
    private TextView intro;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records> call = Api.user();
        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                String a = response.body().getFields(1).getUsername();
                user_Name = getView().findViewById(R.id.username_own_account);
                user_Name.setText(a);
                String b = response.body().getFields(1).getAboutme();
               intro= getView().findViewById(R.id.intro);
                intro.setText(b);
            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {

            }
        });


        return inflater.inflate(R.layout.account_fragment, container, false);

    }

    public void get() {
        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records> call = Api.user();
        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                String a = response.body().getFields(1).getUsername();
                user_Name = getView().findViewById(R.id.username_own_account);
                user_Name.setText(a);


            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {

            }
        });


    }
}
