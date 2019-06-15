package com.example.satest.Retrofit;

import java.util.List;

public class User_data {


    public String User_name;

    public User_data(String User_name, String Email, String Password) {
       this.User_name = User_name;
        this.Email = Email;
        this.Password = Password;
    }

    public String Email;
    public String Password;
    public String image;
    public String account;




    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getImage() {
        return image;
    }

    public String getAccount() {
        return account;
    }

    public String getUsername() {
        return User_name;
    }


}
