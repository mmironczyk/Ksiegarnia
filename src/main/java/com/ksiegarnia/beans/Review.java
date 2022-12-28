package com.ksiegarnia.beans;

import com.ksiegarnia.model.UserDbModel;

public class Review {
    private int reviewId;
    private int userId;
    private int productId;
    private String reviewText;
    private String reviewImage;
    private String link;

    public Review(int reviewId, int userId, int productId, String reviewText, String reviewImage, String link) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.reviewText = reviewText;
        this.reviewImage = reviewImage;
        this.link = link;
    }

    public Review() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewImage() {
        return reviewImage;
    }

    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String linkToIFrameLink() {
        String iLink = this.link;
        if (iLink.contains("https://www.youtube.com/embed/")) {
            return iLink;
        } else if (iLink.contains("https://www.youtube.com/watch?v=")) {
            String[] linkParts = iLink.split("=");
            iLink = "https://www.youtube.com/embed/" + linkParts[1] + "?autoplay=0";
            return iLink;
        }
        return "";
    }
}
