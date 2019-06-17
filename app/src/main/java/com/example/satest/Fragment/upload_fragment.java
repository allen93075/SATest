package com.example.satest.Fragment;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.satest.MainActivity;
import com.example.satest.R;
import com.example.satest.Retrofit.Api;
import com.example.satest.Retrofit.Image_attachment;
import com.example.satest.Retrofit.Image_data;
import com.example.satest.Retrofit.Records_image;
import com.example.satest.Retrofit.RetrofitManager;
import com.example.satest.Retrofit.Url;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

import static android.app.Activity.RESULT_OK;

public class upload_fragment extends Fragment{

    public FirebaseStorage storage = FirebaseStorage.getInstance();
    public ImageView imageView;
    public Bitmap bitmap;
    public ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.upload_fragment, container, false);

        Button selectButton = (Button) view.findViewById(R.id.select_image);
        final Button uploadButton = (Button) view.findViewById(R.id.upload_ready);
        final EditText textInput = (EditText) view.findViewById(R.id.description);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        uploadButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                bitmap = imageView.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                imageView.setDrawingCacheEnabled(true);
                byte[] data = baos.toByteArray();

                String path = UUID.randomUUID() + ".png";
                StorageReference firebaseRdf = storage.getReference(path);
                StorageMetadata metadata = new StorageMetadata.Builder()
                        .setCustomMetadata("description", textInput.getText().toString()).build();

                progressBar.setVisibility(View.VISIBLE);
                uploadButton.setEnabled(false);
                UploadTask uploadTask = firebaseRdf.putBytes(data, metadata);
                uploadTask.addOnSuccessListener(getActivity(), new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressBar.setVisibility(View.GONE);
                        Toast toast = Toast.makeText(getActivity(),"Success!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        uploadButton.setEnabled(true);

                        Uri url = taskSnapshot.getUploadSessionUri();
                        String s_url = url.toString();


                        Api api = RetrofitManager.getInstance().getAPI();
                        Call<Records_image> call= api.Post_image(new Url(new Image_data(textInput.getText().toString(),
                                "1","1",new Image_attachment(s_url))));
                        call.enqueue(new Callback<Records_image>() {
                            @Override
                            public void onResponse(Call<Records_image> call, Response<Records_image> response) {

                            }

                            @Override
                            public void onFailure(Call<Records_image> call, Throwable t) {

                            }
                        });

//                        toast = Toast.makeText(getActivity(), url.toString(), Toast.LENGTH_LONG);
//                        toast.show();
                    }
                });
            }
        });

        selectButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                //開啟Pictures畫面Type設定為image
                intent.setType("image/*");
                //使用Intent.ACTION_GET_CONTENT這個Action                                            //開啟選取圖檔視窗讓您選取手機內圖檔
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片後返回本畫面
                startActivityForResult(intent, 1);
            }

        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當使用者按下確定後
        if (resultCode == RESULT_OK) {
            //取得圖檔的路徑位置
            Uri uri = data.getData();
            //寫log
            Log.e("uri", uri.toString());
            //抽象資料的接口
            ContentResolver cr = this.getActivity().getContentResolver();
            try {
                //由抽象資料接口轉換圖檔路徑為Bitmap
                bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                //取得圖片控制項ImageView
                imageView = (ImageView) getView().findViewById(R.id.upload_image);
                // 將Bitmap設定到ImageView
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
