package com.example.demo2;

public class BloggPost {

    private int id;
    private String message;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BloggPost{" +
                "id=" + id +
                ", message=" + message +
                ", title='" + title + '\'' +
                '}';


    }
}
