package com.novelreviewer.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Novel {
    @SerializedName("Author")
    private String author;

    @SerializedName("Rating")
    private String rating;

    @SerializedName("Chapters")
    private String chapters;

    public Novel() {}

    public Novel(String author, String rating, String chapters) {
        this.author = author;
        this.rating = rating;
        this.chapters = chapters;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Novel fromJson(String json) {
        return new Gson().fromJson(json, Novel.class);
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Rating: " + rating + ", Chapters: " + chapters;
    }
}
