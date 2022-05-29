package com.example.jsonparsing;

public class PostModelClass {

    String title;
    String data;
    String excerpt;
    String img;
    String id;
    String content;

    public PostModelClass(String title, String data, String excerpt, String img, String id, String content) {
        this.title = title;
        this.data = data;
        this.excerpt = excerpt;
        this.img = img;
        this.id = id;
        this.content = content;
    }

    public PostModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
