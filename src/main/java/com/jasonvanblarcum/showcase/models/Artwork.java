package com.jasonvanblarcum.showcase.models;

public class Artwork extends AbstractEntity {

    private String title;

    private String media;

    private String year;

    public Artwork(String title, String media, String year) {
        this.title = title;
        this.media = media;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
