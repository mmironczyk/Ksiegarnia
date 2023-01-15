package com.ksiegarnia.beans;
/** klasa reprezentująca uzytkownika */
public class User implements Cloneable{

    private String login;
    private String imie;
    private String nazwisko;
    private int userId;
    private String email;
    private String haslo;
    private String adres;
    private String miasto;
    private String kod_pocztowy;
    private String telefon;

    private String rola;
    public User() {}
    /** funkcja zwracająca login usera
     * @return String login
     * */
    public String getLogin() {
        return login;
    }
    /** funkcja ustawiająca login usera
     * @param  login login usera
     * */
    public void setLogin(String login) {
        this.login = login;
    }
    /** funkcja zwracająca imie usera
     * @return String imie
     * */
    public String getImie() {
        return imie;
    }
    /** funkcja ustawiająca imie usera
     * @param  imie imie usera
     * */
    public void setImie(String imie) {
        this.imie = imie;
    }
    /** funkcja zwracająca nazwisko usera
     * @return String nazwisko
     * */
    public String getNazwisko() {
        return nazwisko;
    }
    /** funkcja ustawiająca nazwisko usera
     * @param  nazwisko nazwisko usera
     * */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    /** funkcja zwracająca miasto usera
     * @return String miasto
     * */
    public String getMiasto() {
        return miasto;
    }
    /** funkcja ustawiająca miasto usera
     * @param miasto miasto usera
     * */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
    /** funkcja zwracająca email usera
     * @return String email
     * */
    public String getEmail() {
        return email;
    }
    /** funkcja ustawiająca emial usera
     * @param email email usera
     * */
    public void setEmail(String email) {
        this.email = email;
    }
    /** funkcja zwracająca haslo usera
     * @return String haslo
     * */
    public String getHaslo() {
        return haslo;
    }
    /** funkcja ustawiająca haslo usera
     * @param haslo haslo usera
     * */
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    /** funkcja zwracająca adres usera
     * @return String adres
     * */
    public String getAdres() {
        return adres;
    }
    /** funkcja ustawiająca adres usera
     * @param address adres usera
     * */
    public void setAdres(String address) {
        this.adres = address;
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
    /** funkcja zwracająca kod
     * @return String kod_pocztowy
     * */
    public String getKod() {
        return kod_pocztowy;
    }
    /** funkcja ustawiająca kod
     * @param  kod_pocztowy kod pocztowy
     * */
    public void setKod(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
    /** funkcja zwracająca telefon
     * @return String telefon
     * */
    public String getTelefon() {
        return telefon;
    }
    /** funkcja ustawiająca telefon
     * @param  telefon telefon
     * */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    /** funkcja zwracająca role
     * @return String rola
     * */
    public String getRola() {
        return rola;
    }
    /** funkcja ustawiająca role
     * @param  rola rola
     * */
    public void setRola(String rola) {
        this.rola = rola;
    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
