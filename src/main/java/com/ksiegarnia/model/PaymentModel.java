package com.ksiegarnia.model;

import com.ksiegarnia.beans.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** Model dla płatności */
public class PaymentModel {

    ResultSet rs = null;
    Connection con;

    DbConnection db = new DbConnection();

    /** Funkcja dodająca zarejestrowaną płatność do bazy danych
     * @param pay obiekt klasy Payment
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * @see com.ksiegarnia.beans.Payment
     * */
    public boolean addPayment(Payment pay) {
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("INSERT INTO platnosci(id_klienta,nr_zamowienia,kwota,rabat_procent) VALUES (?,?,?,?)");
            pst.setInt(1, pay.getId_klienta());
            pst.setString(2, pay.getNr_zamowienia());
            pst.setFloat(3, pay.getKwota());
            pst.setFloat(4, pay.getRabat());
            int executeUpdate = pst.executeUpdate();
            pst.close();
            db.closeConnection();
            if (executeUpdate > 0)
                return true;
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return false;
    }
}