package com.jhennis.store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    private int productId;
    private String title;
    private double price;
    private String description;

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
