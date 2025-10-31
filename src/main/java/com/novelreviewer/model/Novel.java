package com.novelreviewer.model;

public class Novel {
    private String title;
    private String rating;
    private String num_chapters;
    private String author;

    public Novel(String title, String num_chapters, String rating, String author) {
        this.title = title;
        this.rating = rating;
        this.num_chapters = num_chapters;
        this.author = author;
    }
}
