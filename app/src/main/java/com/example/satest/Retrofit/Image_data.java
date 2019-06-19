package com.example.satest.Retrofit;

public class Image_data {
    //private String id;
    private picture_data[] Image;
    private String Image_id;
    private String Description;
    private String[] User;

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

    public String[] getUser() {
        return User;
    }

    public Image_data(String Description, String Image_id) {
        this.Description = Description;
        this.Image_id = Image_id;

    }
}
