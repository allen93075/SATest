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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.ArrayList;

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
    //private RadioGroup rg1;
    private RadioButton rb_Image_id,rb_User;
    private String RaidButtonSelect;
    private int userCount = 0;
    private String[] User_Name_ID;
    private int itemCount = 0;

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
        Search = searchView.findViewById(R.id.search);
        tv2 = searchView.findViewById(R.id.tv2);
        searchbox2 = searchView.findViewById(R.id.searchbox2);
        //showPicture = searchView.findViewById(R.id.imageView);
        Search.setOnClickListener(this);

        recyclerView = searchView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //rg1=searchView.findViewById(R.id.radioGroup1);

        rb_Image_id=searchView.findViewById(R.id.Search_Image_id);
        rb_User=searchView.findViewById(R.id.Search_User);

        rb_Image_id.setOnCheckedChangeListener(mOnCheckedChangeListener);
        rb_User.setOnCheckedChangeListener(mOnCheckedChangeListener);

        //return inflater.inflate(R.layout.begin_search, container, false);
        return searchView;
    }
    @Override
    public void onClick(View v) {
        Api Api1 = RetrofitManager.getInstance().getAPI();
        //讀取AirTable中的User Table資料: Begin
        Call<Records> call1 = Api1.user();
        call1.enqueue(new Callback<Records>() {
            @Override
            public void onResponse(Call<Records> call1, Response<Records> response) {
                userCount = 0;  //紀錄真正有存放User的資料筆數
                for (int i = 0; i < response.body().getRecords().length; i++) {
                    String user_id = response.body().getId(i);
                    if (user_id != null) userCount++;
                }
                User_Name_ID = new String[userCount]; //存放User Id與User Name的陣列
                userCount = 0;
                for (int i = 0; i < response.body().getRecords().length; i++) {
                    String user_name = response.body().getFields(i).getUsername();
                    String user_id = response.body().getId(i);
                    if (user_id != null && user_name != null) {
                        User_Name_ID[userCount] = user_id + "/" + user_name;
                        userCount++;
                    }
                }
            }
            @Override
            public void onFailure(Call<Records> call1, Throwable t) {
            }

        });
        //讀取AirTable中的User Table資料: End

        Api Api = RetrofitManager.getInstance().getAPI();
        Call<Records_image> call = Api.image();
        call.enqueue(new Callback<Records_image>() {
            @Override
            public void onResponse(Call<Records_image> call, Response<Records_image> response) {
                String inputByUser = searchbox2.getText().toString();
                //依據User選取的Search類型(Image_id或是User)，來決定要用Image_id或是User來搜尋圖片
                switch (RaidButtonSelect) {
                    case "Search_Image_id":
                        itemCount = 0;  //紀錄真正有存放圖片的資料筆數
                        int m = 0; //紀錄要傳給MyAdapter的Array大小
                        for (int i = 0; i < response.body().getRecords().length; i++) {
                            String image_id_result = response.body().getFields(i).getImage_id();
                            if (image_id_result != null)
                                if ((image_id_result.equals(inputByUser)) ||
                                    (image_id_result.indexOf(inputByUser) >= 0)) {
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
                                //MOD-20190618: Begin
                                String[] User = response.body().getFields(i).getUser();
                                int id_found = -1;
                                String user_name = "No User Name";
                                if (User != null) {
                                    for (int k = 0; k < userCount; k++) {
                                        id_found = User_Name_ID[k].indexOf(User[0]);
                                        if (id_found >= 0) {
                                            id_found = User_Name_ID[k].indexOf("/");
                                            user_name = User_Name_ID[k].substring(id_found + 1
                                            ); //取出後面的User Name資料
                                            k = userCount;
                                        }
                                    }
                                }
                                //MOD-20190618: End
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
                                        //MOD-20190618: Add user_name in below line
                                        itemsData[m] = new ItemData(imageUrl, imageDescription, image_id_result,user_name);
                                        m++;
                                    }
                                    else if(image_id_result.indexOf(inputByUser) >= 0) {
                                        //MOD-20190618: Add user_name in below line
                                        itemsData[m] = new ItemData(imageUrl, imageDescription, image_id_result,user_name);
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
                        break;
















                    case "Search_User":
                        //須將User輸入的資料(ex. kevinichao)轉換成id資料(recfgeZOansiNUD5A)，再依據id資料到
                        //Image Table尋找圖片
                        int id_found = -1, idInList=0;
                        int userName_found = -1;
                        String user_id = "";
                        String user_name = "No User Name"; //MOD-20190618: Add
                        ArrayList<String> userIdList = new ArrayList<>(); //MOD-20190618: Add 存放User Id清單
                        for (int i = 0; i < userCount; i++) {
                            id_found = User_Name_ID[i].indexOf(inputByUser);
                            if( id_found >= 1) {
                                user_id = User_Name_ID[i].substring(0,id_found-1); //取出前面的id資料
                                //MOD-20190618: Begin
                                userName_found = User_Name_ID[i].indexOf("/");
                                user_name = User_Name_ID[i].substring(userName_found + 1
                                ); //取出後面的User Name資料
                                if (user_name.indexOf(inputByUser)>=0) {
                                    userIdList.add(user_id); //將找到的User Id加入清單中
                                    idInList = 1;
                                }
                                //MOD-20190618: End
                                //i = userCount; //MOD-20190618: Remark
                            }
                        }
                        if(idInList == 1) {
                            itemCount = 0;  //紀錄真正有存放圖片的資料筆數
                            m = 0; //紀錄要傳給MyAdapter的Array大小
                            for (int i = 0; i < response.body().getRecords().length; i++) {
                                String[] User = response.body().getFields(i).getUser(); //取出AirTable的User欄位資料
                                if ( User[0]!= null) {
                                    if (User[0].equals(user_id)) {
                                        itemCount++;  //決定Array ItemData[]的大小
                                    }
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
                                    String[] User = response.body().getFields(i).getUser(); //取出User欄位資料
                                    if (image_id_result != null) {
                                        if ( User[0]!= null) {
                                            //if (User[0].equals(user_id)) {
                                            if (userIdList.contains(User[0])) {
                                                //MOD-20190618: Add user_name in below line
                                                itemsData[m] = new ItemData(imageUrl, imageDescription,
                                                                            image_id_result,user_name);
                                                m++;
                                            }
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
                        else Toast.makeText(getActivity(),"Cannot find any picture.",Toast.LENGTH_LONG).show();
                        break;
                }

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
    /*
    public void onSelect(View view){
        switch(view.getId()){
            case R.id.Search_Image_id:
                Toast.makeText(getActivity(), "Image_id Selected", Toast.LENGTH_SHORT).show();
                RaidButtonSelect = "Search_Image_id";
                break;
            case R.id.Search_User:
                Toast.makeText(getActivity(), "User Selected", Toast.LENGTH_SHORT).show();
                RaidButtonSelect = "Search_User";
                break;
        }
    }
    */

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.Search_Image_id:
                    if (isChecked) {
                        Toast.makeText(getActivity(), "Image_id Selected", Toast.LENGTH_SHORT).show();
                        RaidButtonSelect = "Search_Image_id";
                    }
                    break;
                case R.id.Search_User:
                    if (isChecked) {
                        Toast.makeText(getActivity(), "User Selected", Toast.LENGTH_SHORT).show();
                        RaidButtonSelect = "Search_User";
                    }
                    break;
            }
        }
    };


}