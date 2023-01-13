package com.ksiegarnia.beans;
/** klasa reprezentująca rezerwacje */
import java.sql.Date;
import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private int userId;
    private int productId;
    private int quantity;
    private Date expire_date;

    /** funkcja zwracająca id rezerwacji
     * @return int reservationId
     * */
    public int getReservationId() {
        return reservationId;
    }
    /** funkcja ustawiająca id rezerwacji
     * @param int reservationId id rezerwacji
     * */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    /** funkcja zwracająca id usera
     * @return int userId
     * */
    public int getUserId() {
        return userId;
    }
    /** funkcja ustawiająca id usera
     * @param int userId id usera
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
    /** funkcja ustawiająca id koszyka
     * @param int cartId id koszyka
     * */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /** funkcja zwracająca ilosc
     * @return int quantity
     * */
    public int getQuantity() {
        return quantity;
    }
    /** funkcja ustawiająca ilosc
     * @param int quantity ilosc
     * */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /** funkcja zwracająca date wygaśniecia
     * @return Date expire_date
     * */
    public Date getExpire_date() {
        return expire_date;
    }
    /** funkcja ustawiająca date wygaśnięcia
     * @param Date expire_date data wygasniecia
     * */
    public void setExpire_date(Date expire_date) {
        this.expire_date = Date.valueOf(expire_date.toLocalDate().plusDays(7));
    }

    public Reservation() {
    }

    public Reservation(int reservationId, int userId, int productId, int quantity, Date expire_date) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.expire_date = expire_date;
    }




}
