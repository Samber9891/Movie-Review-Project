package com.tts.badflicks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// identifies the blogpost as a POJO (plain old java project)
@Entity
public class BlogPost {
    

// properties of a blogpost
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    private String title;
    private String genre;
    private String blogEntry;
    private String imageUrl;

    
    // default constructor. for the jpa
    public BlogPost() {
    }

    

    public BlogPost(String title, String genre, String blogEntry, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.blogEntry = blogEntry;
        this.imageUrl = imageUrl;
    }


    // getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "BlogPost [blogEntry=" + blogEntry + ", genre=" + genre + ", id=" + id + ", imageUrl=" + imageUrl
                + ", title=" + title + "]";
    }

   
    
}
