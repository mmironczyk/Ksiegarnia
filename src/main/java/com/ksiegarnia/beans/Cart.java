package com.ksiegarnia.beans;
/** klasa reprezentująca koszyk */
public class Cart {
    private int cartId;
    private int userId;
    private int productId;
    private int quantity;

    public Cart() {
    }

    public Cart(int cartId)
    {
        this.cartId = cartId;
    }

    public Cart(int cartId, int userId, int productId, int quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }
    /** funkcja zwracająca id koszyka
     * @return int cartId
     * */
    public int getCartId() {
        return cartId;
    }
    /** funkcja zwracająca id usera
     * @return int userId
     * */
    public int getUserId() {
        return userId;
    }
    /** funkcja zwracająca id produktu
     * @return int productId
     * */
    public int getProductId() {
        return productId;
    }
    /** funkcja ustawiająca id koszyka
     * @param int cartId id koszyka
     * */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    /** funkcja ustawiająca id usera
     * @param int userId id usera
     * */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /** funkcja ustawiająca id produktu
     * @param int productId id produktu
     * */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /** funkcja ustawiająca ilosc
     * @param int quantity ilosc
     * */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /** funkcja zwracająca ilosc
     * @return int quantity
     * */
    public int getQuantity() {
        return quantity;
    }


}
