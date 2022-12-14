package com.ksiegarnia.beans;

public class ProductinCart {
    public ProductinCart(int cartId, int userId, String title, double cost, String image, String description, String date, int amount, int pages, int productId, String category, String author) {
        this.cartId = cartId;
        this.userId = userId;
        this.title = title;
        this.cost = cost;
        this.image = image;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.pages = pages;
        this.productId = productId;
        this.category = category;
        this.author = author;
    }

    private int cartId;
        private int userId;

    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    private String title;
        private double cost;
        private String image;
        private String description;
        private String date;
        private int amount;
        private int pages;
        private int productId;
        private String category;
        private String author;
        public ProductinCart(){}
    }
