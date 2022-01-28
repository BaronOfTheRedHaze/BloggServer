package com.example.demo2;

public class BloggPost {

    private int id;
    private int rating;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
                ", rating=" + rating +
                ", title='" + title + '\'' +
                '}';


    }
}
