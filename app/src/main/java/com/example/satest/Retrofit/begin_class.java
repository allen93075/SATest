package com.example.satest.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satest.Fragment.Front;
import com.example.satest.R;
import com.example.satest.search_designer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class begin_class extends AppCompatActivity {

    private EditText Username_input;
    private Button LastPage;
    private Button Search;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin_search);

        Username_input = (EditText) findViewById(R.id.searchbox2);
        LastPage = (Button) findViewById(R.id.lastbotton);
        LastPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(begin_class.this, Front.class);
                startActivity(intent);
            }
        });
        tv2 = (TextView) findViewById(R.id.tv2);
        Search = (Button) findViewById(R.id.search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Api Api = RetrofitManager.getClient().create(Api.class);
                Call<Field> call = Api.user();
                call.enqueue(new Callback<Field>() {
                    @Override
                    public void onResponse(Call<Field> call, Response<Field> response) {
                        for (int i = 0; i < response.body().getRecords().length; i++) {
                            String user = response.body().getFields(i).username;
                            if (Username_input.equals(null)) {
                                tv2.setText("Please type a name ");
                                break;
                            }
                            if (user.equals(Username_input.getText().toString())) {
                                Intent intent = new Intent();
                                intent.setClass(begin_class.this, search_designer.class);
                                startActivity(intent);
                            } else {
                                tv2.setText("Not Found , try again");
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
    }
}