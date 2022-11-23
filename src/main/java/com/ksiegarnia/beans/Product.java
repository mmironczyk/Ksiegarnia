package com.ksiegarnia.beans;

public class Product {
    private String name;
    private double cost;
    private String image;
    private String description;
    private String date;
    private int amount;
    private int productId;
    private int category;
    private int author;

    public Product(String name, double cost, String image, String description, String date, int amount, int productId, int category, int author) {
        this.name = name;
        this.cost = cost;
        this.image = image;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.productId = productId;
        this.category = category;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }






}
