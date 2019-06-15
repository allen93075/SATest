package com.example.satest.Fragment;

public class ItemData {
    private String url;
    private String Image_id;
    private String Description;

    public String itemGetDescription() {
        return Description;
    }
    public String itemGetImage_id() {
        return Image_id;
    }
    public String itemGetUrl() { return url;  }

    public ItemData(String url, String Description, String Image_id) {
      this.Description = Description;
      this.Image_id = Image_id;
      this.url = url;
    }
}
