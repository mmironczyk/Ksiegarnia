package com.ksiegarnia.beans;

public class Order {

    int id_zamowienia;

    public float getCena_sztuka() {
        return cena_sztuka;
    }

    public void setCena_sztuka(float cena_sztuka) {
        this.cena_sztuka = cena_sztuka;
    }

    float cena_sztuka;
    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
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

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public int getIlosc_produktu() {
        return ilosc_produktu;
    }

    public void setIlosc_produktu(int ilosc_produktu) {
        this.ilosc_produktu = ilosc_produktu;
    }

    int id_klienta;
    String nr_zamowienia;
    int id_produktu;
    int ilosc_produktu;

    public Order() {
    }

    public Order(int id_zamowienia, int id_klienta, String nr_zamowienia, int id_produktu, int ilosc_produktu) {
        this.id_zamowienia = id_zamowienia;
        this.id_klienta = id_klienta;
        this.nr_zamowienia = nr_zamowienia;
        this.id_produktu = id_produktu;
        this.ilosc_produktu = ilosc_produktu;
    }
}