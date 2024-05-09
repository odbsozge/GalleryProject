package org.example.magnificentgallery.Entity;


import java.util.ArrayList;

public class Painting {

    private int id;
    private String name;
    private String artist;
    private String year;
    private String url;
    private double price;
    private int parentId;

    // Constructors
    public Painting() {}

    public Painting(int id, String name, String artist, String year, String url, double price, int parentId) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.url = url;
        this.price = price;
        this.parentId = parentId;
    }

    public ArrayList<Painting> getPaintings() {
        ArrayList<Painting> paintings = new ArrayList<>();

        paintings.add(new Painting(0, "Login", "", "", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Login.png", 0, -1));
        paintings.add(new Painting(1, "Mona Lisa", "Leonardo Da Vinci", "1503", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/monalisa.jpg", 1500, 0));
        paintings.add(new Painting(2, "Yıldızlı Gece", "Vincent Van Gogh", "1889", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/yıldızlıgece.jpg", 1800, 0));
        paintings.add(new Painting(3, "Çığlık", "Edvard Munch", "1893", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/çığlık.jpg", 3400, 0));
        paintings.add(new Painting(4, "Son Akşam Yemeği", "Leonardo Da Vinci", "1495-1498", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/sonakşamyemeği.jpg", 3567, 0));
        paintings.add(new Painting(5, "Öpücük", "Gustav Klimt", "1907-1908", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/öpücük.jpg", 343, 0));
        paintings.add(new Painting(6, "Guernica", "Pablo Picasso", "1937", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/Guernica.jpg", 454, 0));
        paintings.add(new Painting(7, "Venüsün Doğuşu", "Sandro Botticelli", "1484–1486", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/venüsündoğuşu.jpg", 5454, 0));
        paintings.add(new Painting(8, "Mona Lisa'nın Yüzü", "Leonardo Da Vinci", "1503", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/monalisaface.png", 3567, 1));
        paintings.add(new Painting(9, "Mona Lisa'nın Elleri", "Leonardo Da Vinci", "1503","/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/monalisahands.png", 343, 1));
        paintings.add(new Painting(10, "Son Akşam Yemeği İsa", "Leonardo Da Vinci", "1495-1498", "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/sonakşamyemeğiisa.png", 454, 4));
        paintings.add(new Painting(11, "Yıldızlı Gece'den Bir Parça", "Vincent Van Gogh", "1889",  "/Users/ozgeodabas/Documents/GitHub/GalleryProject/src/images/yıldızlıgeceyıldız.png", 5454, 2));

        return paintings;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}

