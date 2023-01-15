package com.ksiegarnia.beans;
/** klasa reprezentująca opinie */
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
    /** funkcja zwracająca id opinii
     * @return int reviewId
     * */
    public int getReviewId() {
        return reviewId;
    }
    /** funkcja ustawiająca id opinii
     * @param reviewId id opinii
     * */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    /** funkcja zwracająca id usera
     * @return int userId
     * */
    public int getUserId() {
        return userId;
    }
    /** funkcja ustawiająca id usera
     * @param userId id usera
     * */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /** funkcja zwracająca id produktu
     * @return int productId
     * */
    public int getProductId() {
        return productId;
    }
    /** funkcja ustawiająca id produktu
     * @param productId id produktu
     * */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /** funkcja zwracająca tekst opinii
     * @return String reviewText
     * */
    public String getReviewText() {
        return reviewText;
    }
    /** funkcja ustawiająca tekst opinii
     * @param reviewText tekst opinii
     * */
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    /** funkcja zwracająca zdjecie opinii
     * @return String reviewImage
     * */
    public String getReviewImage() {
        return reviewImage;
    }
    /** funkcja ustawiająca zdjecie opinii
     * @param reviewImage zdjecie opinii
     * */
    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }
    /** funkcja zwracająca link opinii
     * @return String link
     * */
    public String getLink() {
        return link;
    }
    /** funkcja ustawiająca link opinii
     * @param link lind opinii
     * */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * funkcja ustawiająca odpowiedni format dla linku do youtube
     */
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
