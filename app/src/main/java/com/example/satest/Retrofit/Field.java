package com.example.satest.Retrofit;

public class Field {

    public Field[] records;
    public String id;
    public User_data fields;

    public Field[] getRecords() {

        return records;
    }

    public Field(String id) {
        this.id = id;

    }

    public String getId(int i) {

        return records[i].id;
    }

    public User_data getFields(int i) {

        return records[i].fields;
    }



}
