package com.example.satest.Retrofit;

public class Image_attachment {
    private String id;
    private String url;
    private String filename;
    private Number size;
    private Number width;
    private Number length;
    private String thumbnailssmallurl;
    private String thumbnailslargeurl;
    private Number thumbnailssmallwidth;
    private Number thumbnailssmallheight;
    private Number thumbnailslargeheight;
    private Number thumbnailslargewidth;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getFilename() {
        return filename;
    }

    public Number getSize() {
        return size;
    }

    public Number getWidth() {
        return width;
    }

    public Number getLength() {
        return length;
    }

    public String getThumbnailssmallurl() {
        return thumbnailssmallurl;
    }

    public String getThumbnailslargeurl() {
        return thumbnailslargeurl;
    }

    public Number getThumbnailssmallwidth() {
        return thumbnailssmallwidth;
    }

    public Number getThumbnailssmallheight() {
        return thumbnailssmallheight;
    }

    public Number getThumbnailslargeheight() {
        return thumbnailslargeheight;
    }

    public Number getThumbnailslargewidth() {
        return thumbnailslargewidth;
    }


    public Image_attachment(String id, String url, String filename, Number size, Number width, Number length, String thumbnailssmallurl, String thumbnailslargeurl, Number thumbnailssmallwidth, Number thumbnailssmallheight, Number thumbnailslargeheight, Number thumbnailslargewidth) {
        this.id = id;
        this.url = url;
        this.filename = filename;
        this.size = size;
        this.width = width;
        this.length = length;
        this.thumbnailssmallurl = thumbnailssmallurl;
        this.thumbnailslargeurl = thumbnailslargeurl;
        this.thumbnailssmallwidth = thumbnailssmallwidth;
        this.thumbnailssmallheight = thumbnailssmallheight;
        this.thumbnailslargeheight = thumbnailslargeheight;
        this.thumbnailslargewidth = thumbnailslargewidth;
    }


}
