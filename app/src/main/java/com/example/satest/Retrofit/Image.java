package com.example.satest.Retrofit;

public class Image {
    private String Image_id;
    private Image_attachment image_attachment;
    private String UploadTime;
    private String Comment;
    private String Description;
    private String User;
    private String Tags;

    public String getImage_id() {
        return Image_id;
    }

    public Image_attachment getImage_attachment() {
        return image_attachment;
    }

    public String getUploadTime() {
        return UploadTime;
    }

    public String getComment() {
        return Comment;
    }

    public String getDescription() {
        return Description;
    }

    public String getUser() {
        return User;
    }

    public String getTags() {
        return Tags;
    }


    public Image(String image_id, Image_attachment image_attachment, String uploadTime, String comment, String description, String user, String tags) {
        Image_id = image_id;
        this.image_attachment = image_attachment;
        UploadTime = uploadTime;
        Comment = comment;
        Description = description;
        User = user;
        Tags = tags;
    }


}
