package com.ksiegarnia.beans;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String address) {
        this.adres = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getKod() {
        return kod_pocztowy;
    }
    public void setKod(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getRola() {
        return rola;
    }
    public void setRola(String rola) {
        this.rola = rola;
    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
