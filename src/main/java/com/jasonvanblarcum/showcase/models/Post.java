package com.jasonvanblarcum.showcase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post extends AbstractEntity{

    private String subject;

    private String body;

    private User author;

    private Date date = new Date();

    public Post(){}

    public Post(String subject, String body, User author) {
        this.subject = subject;
        this.body = body;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", date=" + date +
                '}';
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
