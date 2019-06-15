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
import android.widget.TextView;

import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class front_fragment extends Fragment {
    public TextView user_Name1;
    public TextView user_Name2;
    public TextView user_Name3;
    public TextView user_Name4;
    private Button like1;
    private Button comment1;
    private Button massage1;
    private Button like2;
    private Button comment2;
    private Button massage2;
    private Button like3;
    private Button comment3;
    private Button massage3;
    private Button like4;
    private Button comment4;
    private Button massage4;


    @Nullable

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        get();
        return inflater.inflate(R.layout.front_fragment, container, false);


    }

    public void get() {
        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records> call = Api.user();
        call.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call, Response<Records> response) {
                response.body().getFields(1).getUsername();
                String a = response.body().getFields(1).getUsername();
                user_Name1 = getView().findViewById(R.id.user_id1);
                user_Name1.setText(a);
                String b = response.body().getFields(2).getUsername();
                user_Name2 = getView().findViewById(R.id.user_id2);
                user_Name2.setText(b);
                String c = response.body().getFields(3).getUsername();
                user_Name3 = getView().findViewById(R.id.user_id3);
                user_Name3.setText(c);

            }

            @Override
            public void onFailure(Call<Records> call, Throwable t) {

            }
        });

    }


}
