package com.example.satest.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.satest.Fragment.Front;
import com.example.satest.R;
import com.example.satest.search_designer;
import com.example.satest.search_tags;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class begin_class extends AppCompatActivity {

    private EditText Username_input;
    private EditText Tags_input;
    private Button LastPage;
    private Button Search;
    private TextView tv2;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin_search);

//        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//        final String[] search_spinner = {"Designer", "Tags"};
//        ArrayAdapter<String> SearchList = new ArrayAdapter<>(begin_class.this,
//                android.R.layout.simple_spinner_dropdown_item,search_spinner
//                );
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
//                                    intent.setClass(begin_class.this, search_designer.class);
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
//                                    intent.setClass(begin_class.this, search_tags.class);
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
        Tags_input= findViewById(R.id.searchbox2);
        Username_input = findViewById(R.id.searchbox2);
        LastPage = findViewById(R.id.searchfordesigner);
        LastPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(begin_class.this, Front.class);
                startActivity(intent);
            }
        });
        tv2 = findViewById(R.id.tv2);
        Search = findViewById(R.id.search);
    }
}