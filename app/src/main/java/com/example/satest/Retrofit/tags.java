package com.example.satest.Retrofit;

public class tags {
    private String Tags;

    public tags(String tags, String image_id, Image_attachment[] image_attachmemt) {
        Tags = tags;
        Image_id = image_id;
        Image_attachmemt = image_attachmemt;
    }

    private String Image_id;

    public Image_attachment[] getImage_attachmemt() {
        return Image_attachmemt;
    }

    private Image_attachment[] Image_attachmemt;
    public String getTags() {
        return Tags;
    }

    public String getImage_id() {
        return Image_id;
    }





}
