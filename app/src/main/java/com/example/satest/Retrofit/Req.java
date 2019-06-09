package com.example.satest.Retrofit;

public class Req {
    public Req(User_data fields) {
        this.fields = fields;
    }

    public User_data getFields() {
        return fields;
    }

    public void setFields(User_data fields) {
        this.fields = fields;
    }

    private User_data fields;

}
