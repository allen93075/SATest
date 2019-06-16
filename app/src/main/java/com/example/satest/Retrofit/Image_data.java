package com.example.satest.Retrofit;

public class Image_data {
    //private String id;
    private picture_data[] Image;
    private String Image_id;
    private String Description;
    private String User_text;

    public String getUser_text() {
        return User_text;
    }








    public String getDescription() {
        return Description;
    }
    public String getImage_id() {
        return Image_id;
    }
    //public String getImageUrl() { return Image.getClass().}

    public picture_data[] getImage() {
        return Image;
    }

    public Image_data(String Description, String Image_id,String User_text) {
        this.Description = Description;
        this.Image_id = Image_id;
        this.User_text = User_text;


    }
}
