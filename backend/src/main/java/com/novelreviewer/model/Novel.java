package com.novelreviewer.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Novel {
    @SerializedName("Title")
    private String title;

    @SerializedName("Author")
    private String author;

    @SerializedName("Chapters")
    private int chapters;
    @SerializedName("Rating")
    private double rating;


    public Novel() {}

    public Novel(String title, String author, int chapters, double rating) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Novel fromJson(String json) {
        return new Gson().fromJson(json, Novel.class);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +  ", Chapters: " + chapters +  ", Rating: " + rating;
    }
}
