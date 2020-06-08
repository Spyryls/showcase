package com.jasonvanblarcum.showcase.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Artwork {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    @NotEmpty(message = "You must submit an image to post.")
    private String image;

    @NotEmpty
    private String title;

    @NotEmpty
    private String media;

    @NotEmpty
    @Size(max = 250, message = "Your description must be under 250 characters.")
    private String description;

    private String year;

    public Artwork() {
    }

    public Artwork(String image, String title, String media, String description, String year) {
        this.image = image;
        this.title = title;
        this.media = media;
        this.description = description;
        this.year = year;
    }

    public Integer getId() { return id;   }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

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
