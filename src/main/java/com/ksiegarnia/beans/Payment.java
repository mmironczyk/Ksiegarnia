package com.ksiegarnia.beans;
/** klasa reprezentująca płatności */
public class Payment {

    int id_platnosci;
    /** funkcja zwracająca rabat
     * @return float rabat
     * */
    public float getRabat() {
        return rabat;
    }
    /** funkcja ustawiająca rabat
     * @param float rabat rabat
     * */
    public void setRabat(float rabat) {
        this.rabat = rabat;
    }

    float rabat;
    /** funkcja zwracająca id_platnosci
     * @return int id_platnosci
     * */
    public int getId_platnosci() {
        return id_platnosci;
    }
    /** funkcja ustawiająca id platoności
     * @param int id_platnosci id platnosci
     * */
    public void setId_platnosci(int id_platnosci) {
        this.id_platnosci = id_platnosci;
    }
    /** funkcja zwracająca id klienta
     * @return int id_klienta
     * */
    public int getId_klienta() {
        return id_klienta;
    }
    /** funkcja ustawiająca id klienta
     * @param int id_klienta id klienta
     * */
    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }
    /** funkcja zwracająca id klienta
     * @return int id_klienta
     * */
    public String getNr_zamowienia() {
        return nr_zamowienia;
    }
    /** funkcja ustawiająca id klienta
     * @param int id_klienta id klienta
     * */
    public void setNr_zamowienia(String nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }
    /** funkcja zwracająca kwote
     * @return float kwota
     * */
    public float getKwota() {
        return kwota;
    }
    /** funkcja ustawiająca kwote
     * @param float kwota kwota
     * */
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
