package com.ksiegarnia.beans;
/** klasa reprezentująca wpisy w historii zamówień */
public class OrderRecord {

    int id_zamowienia;
    float cena_sztuka;
    int id_klienta;
    String nr_zamowienia;
    int id_produktu;
    int ilosc_produktu;
    float kwota;

    /** funkcja zwracająca id zamówienia
     * @return int id_zamowienia
     * */
    public int getId_zamowienia() {
        return id_zamowienia;
    }
    /** funkcja ustawiająca id zamówienia
     * @param id_zamowienia id zamówienia
     * */
    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }
    /** funkcja zwracająca id klienta
     * @return int id_klienta
     * */
    public int getId_klienta() {
        return id_klienta;
    }
    /** funkcja ustawiająca id klienta
     * @param id_klienta id klienta
     * */
    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }
    /** funkcja zwracająca numer zamówienia
     * @return int nr_zamowienia
     * */
    public String getNr_zamowienia() {
        return nr_zamowienia;
    }
    /** funkcja ustawiająca nr zamówienia
     * @param nr_zamowienia numer zamówienia
     * */
    public void setNr_zamowienia(String nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }
    /** funkcja zwracająca id produktu
     * @return int id_produktu
     * */
    public int getId_produktu() {
        return id_produktu;
    }
    /** funkcja ustawiająca id produktu
     * @param id_produktu id produktu
     * */
    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }
    /** funkcja zwracająca ilość produktów
     * @return int ilosc_produktu
     * */
    public int getIlosc_produktu() {
        return ilosc_produktu;
    }
    /** funkcja ustawiająca ilosc produktów
     * @param ilosc_produktu ilosc produktów
     * */
    public void setIlosc_produktu(int ilosc_produktu) {
        this.ilosc_produktu = ilosc_produktu;
    }

    /** funkcja zwracająca kwotę
     * @return float kwota
     * */
    public float getKwota() {
        return kwota;
    }
    /** funkcja ustawiająca kwotę
     * @param kwota kwota
     * */
    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public OrderRecord(int id_zamowienia,String nr_zamowienia, float kwota)
    {
        this.id_zamowienia = id_zamowienia;
        this.nr_zamowienia=nr_zamowienia;
        this.kwota=kwota;
    }
    public OrderRecord(int id_zamowienia, int id_klienta, String nr_zamowienia, int id_produktu, int ilosc_produktu, float kwota) {
        this.id_zamowienia = id_zamowienia;
        this.id_klienta = id_klienta;
        this.nr_zamowienia = nr_zamowienia;
        this.id_produktu = id_produktu;
        this.ilosc_produktu = ilosc_produktu;
        this.kwota = kwota;
    }
    public OrderRecord() {
    }
}