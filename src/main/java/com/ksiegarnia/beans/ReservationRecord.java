package com.ksiegarnia.beans;

import java.sql.Date;
/** klasa reprezentująca rezerwację w historii*/
public class ReservationRecord {

    private int reservationId;
    private int userId;
    private int productId;
    private int quantity;
    private Date expire_date;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = Date.valueOf(expire_date.toLocalDate().plusDays(7));
    }
    public ReservationRecord() {}
    public ReservationRecord(int reservationId, int userId, int productId, int quantity, Date expire_date, String title) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.expire_date = expire_date;
        this.title = title;
    }
}
