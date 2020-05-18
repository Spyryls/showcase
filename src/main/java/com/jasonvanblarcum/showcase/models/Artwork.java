package com.jasonvanblarcum.showcase.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Artwork extends AbstractEntity {

    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String media;

    @NotEmpty
    @Size(max = 250, message = "Your description must be under 250 characters.")
    private String description;


    private String year;

    public Artwork(String title, String media, String description, String year) {
        this.title = title;
        this.media = media;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
