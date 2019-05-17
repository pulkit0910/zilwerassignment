package com.example.zilwerassignment;

public class cardata {

    public String data;

    public String image;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public cardata(String data, String image) {
        this.data = data;
        this.image = image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
