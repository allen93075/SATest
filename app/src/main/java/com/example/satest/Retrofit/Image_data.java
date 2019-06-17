package com.example.satest.Retrofit;

import android.net.Uri;

public class Image_data {
    //private String id;
    private picture_data[] Image2;
    private String Image_id;
    private String Description;
    private String User_text;
    private Image_attachment Image;

    public String getUser_text() {
        return User_text;
    }

    public Image_attachment getUpload_image(){ return Image; }


    public String getDescription() {
        return Description;
    }
    public String getImage_id() {
        return Image_id;
    }
    //public String getImageUrl() { return Image.getClass().}

    public picture_data[] getImage() {
        return Image2;
    }

    public Image_data(String Description, String Image_id,String User_text, Image_attachment Image) {
        this.Description = Description;
        this.Image_id = Image_id;
        this.User_text = User_text;
        this.Image = Image;



    }
}
