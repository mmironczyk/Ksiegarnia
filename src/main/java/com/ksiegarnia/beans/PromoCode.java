package com.ksiegarnia.beans;

public class PromoCode {

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public PromoCode(int id, String code, float value, int numberofusage) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.numberofusage = numberofusage;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    String code;

    public PromoCode() {
    }

    float value;

    public int getNumberofusage() {
        return numberofusage;
    }

    public void setNumberofusage(int numberofusage) {
        this.numberofusage = numberofusage;
    }

    int numberofusage;


}
