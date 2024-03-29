package com.ksiegarnia.beans;
/** klasa reprezentująca kody rabatowe */
public class PromoCode {

    int id;
    String code;
    float value;
    int numberofusage;

    public PromoCode(int id, String code, float value, int numberofusage) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.numberofusage = numberofusage;
    }

    public PromoCode() {}

    /** funkcja zwracająca id kodu
     * @return int id
     * */
    public int getId() {
        return id;
    }
    /** funkcja ustawiająca id kodu
     * @param id id
     * */
    public void setId(int id) {
        this.id = id;
    }
    /** funkcja zwracająca kod
     * @return String code
     * */
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    /** funkcja zwracająca wartosc kodu
     * @return String code
     * */
    public float getValue() {
        return value;
    }
    /** funkcja ustawiająca wartosc kodu
     * @param value wartosc kodu
     * */
    public void setValue(float value) {
        this.value = value;
    }
    /** funkcja zwracająca liczbe użyć
     * @return int numerofusage
     * */
    public int getNumberofusage() {
        return numberofusage;
    }
    /** funkcja ustawiająca liczbe uzyc
     * @param numberofusage
     * */
    public void setNumberofusage(int numberofusage) {
        this.numberofusage = numberofusage;
    }
}
