package com.example.satest.Fragment;

public class ItemData {
    private String url;
    private String Image_id;
    private String Description;
    private String User; //MOD-20190618: Add


    public String itemGetDescription() {
        return Description;
    }
    public String itemGetImage_id() {
        return Image_id;
    }
    public String itemGetUrl() { return url;  }
    public String itemGetUser() { return User;  } //MOD-20190618: Add

    public ItemData(String url, String Description, String Image_id, String User) {
      this.Description = Description;
      this.Image_id = Image_id;
      this.url = url;
      this.User = User; //MOD-20190618: Add
    }
}
