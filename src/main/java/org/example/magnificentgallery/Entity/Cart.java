package org.example.magnificentgallery.Entity;

public class Cart {
    private Long id;
    private Long userId;
    private Long paintingId;
    private Long paintingPriceId;
    private double price;
    private String userFirstName;
    private String userLastName;
    private String url;

    // Constructors
    public Cart() {}

    public Cart(Long userId, Long paintingId, Long paintingPriceId, double price, String userFirstName, String userLastName, String url) {
        this.userId = userId;
        this.paintingId = paintingId;
        this.paintingPriceId = paintingPriceId;
        this.price = price;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.url = url;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Long paintingId) {
        this.paintingId = paintingId;
    }

    public Long getPaintingPriceId() {
        return paintingPriceId;
    }

    public void setPaintingPriceId(Long paintingPriceId) {
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

