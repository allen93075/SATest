package com.example.satest.Retrofit;

public class Field {

    public Field[] records;
    public String id;
    public User_data fields;

    public Field[] getRecords() {
        return records;
    }

    public String getId(int i) {

        return records[i].id;
    }

    public User_data getFields() {

        return fields;
    }

    public String getUser_id(int i) {
        return records[i].fields.getUser_id();
    }



}
