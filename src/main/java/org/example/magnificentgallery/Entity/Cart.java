package org.example.magnificentgallery.Entity;

public class Cart {
    private int id;
    private int customerId;
    private int paintingId;
    private int paintingPriceId;
    private double price;
    private String costomerFirstName;
    private String customerLastName;
    private String url;

    // Constructors
    public Cart() {}

    public Cart(int i, int customerId, int paintingId, int paintingPriceId, double price, String costomerFirstName, String customerLastName, String url) {
        this.customerId = customerId;
        this.paintingId = paintingId;
        this.paintingPriceId = paintingPriceId;
        this.price = price;
        this.costomerFirstName = costomerFirstName;
        this.customerLastName = customerLastName;
        this.url = url;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getCostomerFirstName() {
        return costomerFirstName;
    }

    public void setCostomerFirstName(String costomerFirstName) {
        this.costomerFirstName = costomerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

