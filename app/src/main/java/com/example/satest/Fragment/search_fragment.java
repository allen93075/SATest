package com.example.satest.Fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Records;
import com.example.satest.Retrofit.Records_image;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.begin_class;
import com.example.satest.Retrofit.picture_data;
import com.example.satest.search_designer;
import com.example.satest.search_tags;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_fragment extends Fragment implements View.OnClickListener {
    @Nullable
    private EditText Username_input;
    private EditText Tags_input;
    private Button LastPage;
    private Button Search;
    private TextView tv2,searchbox2;
    private Spinner spinner;
    private picture_data[] picture;
    private String imageUrl;
    //public ImageView showPicture;
    private RecyclerView recyclerView;
    //public ItemData[] itemsData;
    public View searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //String w = "Hello!";
        //Toast.makeText(this,w, Toast.LENGTH_LONG).show();
        //new AlertDialog.Builder(this).setMessage(w).setTitle("Show User Name")
        //    .setPositiveButton("OK", null).show();
        Toast.makeText(getActivity(),"Please input the search key in TextView field.",Toast.LENGTH_LONG).show();
        //super.onCreate(savedInstanceState);
        searchView = inflater.inflate(R.layout.begin_search, container, false);
        Search = (Button) searchView.findViewById(R.id.search);
        tv2 = searchView.findViewById(R.id.tv2);
        searchbox2 = searchView.findViewById(R.id.searchbox2);
        //showPicture = searchView.findViewById(R.id.imageView);
        Search.setOnClickListener(this);

        recyclerView = searchView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //return inflater.inflate(R.layout.begin_search, container, false);
        return searchView;
    }
    @Override
    public void onClick(View v) {
        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records_image> call = Api.image();
        call.enqueue(new Callback<Records_image>() {
            @Override
            public void onResponse(Call<Records_image> call, Response<Records_image> response) {
                String inputByUser = searchbox2.getText().toString();

                int itemCount = 0;  //紀錄真正有存放圖片的資料筆數
                int m = 0; //紀錄要傳給MyAdapter的Array大小
                for (int i = 0; i < response.body().getRecords().length; i++) {
                  String image_id_result = response.body().getFields(i).getImage_id();
                  if (image_id_result != null)
                    if ((image_id_result.equals(inputByUser)) || (image_id_result.indexOf(inputByUser) >= 0)) {
                        itemCount++;  //決定Array ItemData[]的大小
                    }
                }

                if (itemCount>=1) {
                    ItemData[] itemsData = new ItemData[itemCount];

                    for (int i = 0; i < response.body().getRecords().length; i++) {
                        //將從AirTable讀取的資料放入Array itemsData，其中圖片資料是1個URL網址
                        picture = response.body().getFields(i).getImage();
                        //if (picture != null) imageUrl = picture[0].url;
                        if (picture != null) imageUrl = picture[0].getUrl();
                        String image_id_result = response.body().getFields(i).getImage_id();
                        String imageDescription = response.body().getFields(i).getDescription();
                        //if (image_id_result != null)
                        if (image_id_result != null) {
                            if (image_id_result.equals(inputByUser)) {
                                //tv2.setText("The Image URL is: " + imageUrl);
                                //Picasso.get().load(imageUrl).into(showPicture);
                                //showPicture.setVisibility(View.VISIBLE); //Cannot work
                                //showPicture.setImageDrawable(loadImageFromURL(imageUrl)); //Cannot work
                                //Toast.makeText(getActivity(),"This is onClick message",Toast.LENGTH_LONG).show();
                                //Toast.makeText(getActivity(), imageUrl, Toast.LENGTH_LONG).show();
                                //Toast.makeText(getActivity(), imageDescription, Toast.LENGTH_LONG).show();
                                itemsData[m] = new ItemData(imageUrl, imageDescription, image_id_result);
                                m++;
                            }
                            else if(image_id_result.indexOf(inputByUser) >= 0) {
                                itemsData[m] = new ItemData(imageUrl, imageDescription, image_id_result);
                                m++;
                            }
                        }
                    }
                    if (m >= 1) {
                        //透過mAdapter搭配recyclerView來顯示連續性的圖片資料
                        MyAdapter mAdapter = new MyAdapter(itemsData);
                        recyclerView.setAdapter(mAdapter);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                    }
                }
                if (itemCount == 0 || m == 0)
                   Toast.makeText(getActivity(),"Cannot find any picture.",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Records_image> call, Throwable t) {
            }

            public Drawable loadImageFromURL(String url){
                try{
                    InputStream is = (InputStream) new URL(url).getContent();
                    Drawable draw = Drawable.createFromStream(is, "src");
                    return draw;
                }catch (Exception e) {
                    //TODO handle error
                    Log.i("loadingImg", e.toString());
                    return null;
                }
            }


        });
    }

}