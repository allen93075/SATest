package com.example.satest.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.begin_class;
import com.example.satest.search_designer;
import com.example.satest.search_tags;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_fragment extends Fragment {
    @Nullable
    private EditText Username_input;
    private EditText Tags_input;
    private Button LastPage;
    private Button Search;
    private TextView tv2;
    private Spinner spinner;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.begin_search, container,false);

//        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//        String[] search_spinner = {"Designer", "Tags"};
//        ArrayAdapter<String> SearchList = new ArrayAdapter<>(begin_class.this,
//                android.R.layout.simple_spinner_dropdown_item,search_spinner
//        );
//        spinner.setAdapter(SearchList);
//        if(search_spinner.equals("Designer")){
//            Search.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Api Api = RetrofitManager.getInstance().getAPI();
//                    Call<Records> call = Api.user();
//                    call.enqueue(new Callback<Records>() {
//                        @Override
//                        public void onResponse(Call<Records> call, Response<Records> response) {
//                            for (int i = 0; i < response.body().getRecords().length; i++) {
//                                String user = response.body().getFields(i).getUsername();
//                                if (Username_input==null) {
//                                    tv2.setText("Please type a name.");
//                                    break;
//                                }
//                                if (user.equals(Username_input.getText().toString())) {
//                                    Intent intent = new Intent();
//                                    //intent.setClass(search_fragment.this, search_designer.class);
//                                    startActivity(intent);
//                                } else {
//                                    tv2.setText("Not Found , try again.");
//                                    break;
//                                }
//                            }
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<Records> call, Throwable t) {
//
//                        }
//                    });
//                }
//            });
//        }
//
//        if(search_spinner.equals("Tags")){
//            Search.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Api Api = RetrofitManager.getInstance().getAPI();
//                    Call<Records> call = Api.tags();
//                    call.enqueue(new Callback<Records>() {
//                        @Override
//                        public void onResponse(Call<Records> call, Response<Records> response) {
//                            for (int i = 0; i < response.body().getRecords().length; i++) {
//                                String tag = response.body().getTagsfields(i).getTags();
//                                if (Tags_input==null) {
//                                    tv2.setText("Please type a tag. ");
//                                    break;
//                                }
//                                if (tag.equals(Tags_input.getText().toString())) {
//                                    Intent intent = new Intent();
//                                    //intent.setClass(search_fragment.this, search_tags.class);
//                                    startActivity(intent);
//                                } else {
//                                    tv2.setText("Not Found , try again.");
//                                    break;
//                                }
//                            }
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<Records> call, Throwable t) {
//
//                        }
//                    });
//                }
//            });
//        }
        //Tags_input= (EditText) findViewById(R.id.searchbox2);
        //Username_input = (EditText) findViewById(R.id.searchbox2);
        //LastPage = (Button) findViewById(R.id.lastbotton);
//        LastPage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent();
//                //intent.setClass(search_fragment.this, Front.class);
//                startActivity(intent);
//            }
//        });
        //tv2 = (TextView) findViewById(R.id.tv2);
        //Search = (Button) findViewById(R.id.search);
    }
}
