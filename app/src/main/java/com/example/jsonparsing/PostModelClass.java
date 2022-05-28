package com.example.jsonparsing;

public class PostModelClass {

    String title;
    String data;
    String excerpt;
    String img;

    public PostModelClass(String title, String data, String excerpt, String img) {
        this.title = title;
        this.data = data;
        this.excerpt = excerpt;
        this.img = img;
    }

    public PostModelClass() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
