package com.example.satest.Retrofit;

public class Records_image {
    private Records_image[] records;
    private String id;
    private Image_data fields;
    private String createtime;

    public Records_image(String id, Image_data fields, String createtime) {
        this.id = id;
        this.fields = fields;
        this.createtime = createtime;
    }

    public Records_image[] getRecords() {
        return records;
    }

    public String getId(int i) {

        return records[i].id;
    }

    public Image_data getFields(int i) {

        return records[i].fields;
    }
}
