package org.example.magnificentgallery.Entity;

public class PaintingPrice {

    private int id;

    private int paintingId;

    private double price;

    // Constructors
    public PaintingPrice() {}

    public PaintingPrice(int paintingId, double price) {
        this.paintingId = paintingId;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

