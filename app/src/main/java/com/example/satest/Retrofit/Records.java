package com.example.satest.Retrofit;

public class Records {

    public Records[] records;
    public String id;
    public User_data fields;
    public tags tagsfields;

    public Records(String id, User_data fields, String createtime) {

        this.id = id;
        this.fields = fields;
        this.createtime = createtime;
    }


    public String createtime;


    public Records[] getRecords() {
        return records;
    }

    public String getId(int i) {

        return records[i].id;
    }

    public User_data getFields(int i) {

        return records[i].fields;
    }

    public String getUsername(int i) {
        return records[i].fields.getUsername();


    }
    public tags getTagsfields(int i){
        return records[i].tagsfields;

    }
}
