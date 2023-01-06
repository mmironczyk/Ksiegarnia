package com.ksiegarnia.beans;

public class Payment {

    int id_platnosci;

    public float getRabat() {
        return rabat;
    }

    public void setRabat(float rabat) {
        this.rabat = rabat;
    }

    float rabat;

    public int getId_platnosci() {
        return id_platnosci;
    }

    public void setId_platnosci(int id_platnosci) {
        this.id_platnosci = id_platnosci;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(String nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    int id_klienta;
    String nr_zamowienia;
    float kwota;

    public Payment() {
    }

    public Payment(int id_platnosci, int id_klienta, String nr_zamowienia, float kwota) {
        this.id_platnosci = id_platnosci;
        this.id_klienta = id_klienta;
        this.nr_zamowienia = nr_zamowienia;
        this.kwota = kwota;
    }
}
