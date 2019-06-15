package com.example.satest.Retrofit;

public class picture_data {
    private String id;
    private String url;
    public String getId() {
        return id;
    }
    public String getUrl() {
        return url;
    }

    public picture_data(String id, String url) {
        this.id = id;
        this.url = url;
    }
}
