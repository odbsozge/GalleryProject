package org.example.magnificentgallery.Entity;

public class Cart {
    private int id;
    private int userId;
    private int paintingId;
    private int paintingPriceId;
    private double price;
    private String userFirstName;
    private String userLastName;
    private String url;

    // Constructors
    public Cart() {}

    public Cart(int i, int userId, int paintingId, int paintingPriceId, double price, String userFirstName, String userLastName, String url) {
        this.userId = userId;
        this.paintingId = paintingId;
        this.paintingPriceId = paintingPriceId;
        this.price = price;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.url = url;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public int getPaintingPriceId() {
        return paintingPriceId;
    }

    public void setPaintingPriceId(int paintingPriceId) {
        this.paintingPriceId = paintingPriceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

