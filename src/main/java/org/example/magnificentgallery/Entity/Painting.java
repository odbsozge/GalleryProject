package org.example.magnificentgallery.Entity;


public class Painting {

    private int id;
    private String name;
    private String artist;
    private int year;
    private String url;

    // Constructors
    public Painting() {}

    public Painting(String name, String artist, int year, String url) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.url = url;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

