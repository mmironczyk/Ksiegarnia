package com.ksiegarnia.beans;
/** klasa reprezentująca produkty */
public class Product {
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

    public Product(String title, double cost, String image, String description, String date, int amount, int pages, int productId, String category) {
        this.title = title;
        this.cost = cost;
        this.image = image;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.pages = pages;
        this.productId = productId;
        this.category = category;
    }

    public Product() {

    }
    /** funkcja zwracająca tytul
     * @return String title
     * */
    public String getTitle() {
        return title;
    }
    /** funkcja ustawiająca tytul
     * @param title tytul
     * */
    public void setTitle(String title) {
        this.title = title;
    }
    /** funkcja zwracająca koszt
     * @return double cost
     * */
    public double getCost() {
        return cost;
    }
    /** funkcja ustawiająca koszt
     * @param cost koszt
     * */
    public void setCost(double cost) {
        this.cost = cost;
    }
    /** funkcja zwracająca zdjecie
     * @return String image
     * */
    public String getImage() {
        return image;
    }
    /** funkcja ustawiająca zdjecie
     * @param image zdjecie
     * */
    public void setImage(String image) {
        this.image = image;
    }
    /** funkcja zwracająca opis
     * @return String description
     * */
    public String getDescription() {
        return description;
    }
    /** funkcja ustawiająca opis
     * @param description opis
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    /** funkcja zwracająca date
     * @return String date
     * */
    public String getDate() {
        return date;
    }
    /** funkcja ustawiająca date
     * @param date data
     * */
    public void setDate(String date) {
        this.date = date;
    }
    /** funkcja zwracająca ilosc
     * @return int amount
     * */
    public int getAmount() {
        return amount;
    }
    /** funkcja ustawiająca ilosc
     * @param amount ilosc
     * */
    public void setAmount(int amount) {
        this.amount = amount;
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
    /** funkcja zwracająca kategorie
     * @return String category
     * */
    public String getCategory() {
        return category;
    }
    /** funkcja ustawiająca kategorie
     * @param category kategoria
     * */
    public void setCategory(String category) {
        this.category = category;
    }
    /** funkcja zwracająca strony
     * @return int pages
     * */
    public int getPages() {
        return pages;
    }
    /** funkcja ustawiająca strony
     * @param pages strony
     * */
    public void setPages(int pages) {
        this.pages = pages;
    }
    /** funkcja zwracająca autora
     * @return String author
     * */
    public String getAuthor() {
        return author;
    }
    /** funkcja ustawiająca autora
     * @param author autor
     * */
    public void setAuthor(String author) {
        this.author = author;
    }
}
