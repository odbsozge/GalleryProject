package org.example.magnificentgallery.Entity;

import java.util.ArrayList;

public class Cart {
    private int userId;
    private int count;
    private String paintingName;
    private double price;
    private String url;

    public Cart(){}

    public Cart(int userId, int count,String paintingName, double price, String url){
        this.userId =userId;
        this.count = count;
        this.paintingName = paintingName;
        this.price = price;
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getUrl() {
        return url;
    }

    public String getPaintingName() {
        return paintingName;
    }

    public int getUserId() {
        return userId;
    }
}

