package com.ksiegarnia.model;

import com.ksiegarnia.beans.PromoCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Model dla kodów rabatowych */
public class PromoCodeModel {

    ResultSet rs = null;
    Connection con;

    DbConnection db = new DbConnection();

    /** Funkcja dodająca kod promocyjny do bazy danych
     * @param code obiekt klasy PromoCode
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public boolean addCode(PromoCode code) {
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("INSERT INTO kody_rabatowe(kod,wartosc_rabatu,ilosc_uzyc)VALUES (?,?,?)");
            pst.setString(1, code.getCode());
            pst.setDouble(2, code.getValue());
            pst.setInt(3, code.getNumberofusage());
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
    /** Funkcja wyszukująca kod promocyjny w bazie danych
     * @param id obiekt klasy PromoCode
     * @return Funkcja zwraca obiekt klasy <b>PromoCode</b> zawierający znaleziony kod promocyjny jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>null</b>.
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public PromoCode getCode(int id) {
        PromoCode code = new PromoCode();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM kody_rabatowe WHERE id_rabatu=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                code.setId(rs.getInt("id_rabatu"));
                code.setCode(rs.getString("kod"));
                code.setValue(rs.getFloat("wartosc_rabatu"));
                code.setNumberofusage(rs.getInt("ilosc_uzyc"));
                db.closeConnection();
                return code;
            }
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return null;
    }
    /** Funkcja zwiększająca stan licznika użycia kodu rabatowego w bazie danych
     * @param s łańcuch znaków kodu rabatowego
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public void addUsage(String s)
    {
        PromoCode code = new PromoCode();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("UPDATE kody_rabatowe SET ilosc_uzyc=ilosc_uzyc+1 WHERE kod=?");
            pst.setString(1, " "+s);
            int executeUpdate = pst.executeUpdate();
            db.closeConnection();
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
    }

    /** Funkcja wyszukująca kod promocyjny w bazie danych na podstawie łańcucha znaków zadanego kodu rabatowego
     * @param s łańcuch znaków kodu rabatowego
     * @return Funkcja zwraca obiekt klasy <b>PromoCode</b> zawierający znaleziony kod promocyjny jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>null</b>.
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public PromoCode getCodeFromString(String s) {
        PromoCode code = new PromoCode();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM kody_rabatowe WHERE kod=?");
            pst.setString(1, " "+s);
            rs = pst.executeQuery();
            if (rs.next()) {
                code.setId(rs.getInt("id_rabatu"));
                System.out.println(rs.getInt("id_rabatu"));
                code.setCode(rs.getString("kod"));
                System.out.println(rs.getString("kod"));
                code.setValue(rs.getFloat("wartosc_rabatu"));
                System.out.println(rs.getDouble("wartosc_rabatu"));
                code.setNumberofusage(rs.getInt("ilosc_uzyc"));
                System.out.println(rs.getInt("ilosc_uzyc"));
                db.closeConnection();
                return code;
            }
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return null;
    }

    /** Funkcja usuwająca kod promocyjny w bazie danych na podstawie id zadanego kodu rabatowego
     * @param id id danego kodu rabatowego
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public boolean deleteCode(int id) {
        try {
            PromoCode code = getCode(id);
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("DELETE FROM kody_rabatowe WHERE id_rabatu=?");
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();
            db.closeConnection();
            if (executeUpdate > 0)
                return true;
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
            return false;
        }
        return false;
    }
    /** Funkcja zwracająca ArrayList-e kodów promocyjnych znajdujących się w bazie danych
     * @return Funkcja zwraca <b>ArrayList-e</b> obiektów klasy <b>PromoCode</b>.
     * @see com.ksiegarnia.beans.PromoCode
     * */
    public ArrayList<PromoCode> getAllCodes() {
        ArrayList<PromoCode> list = new ArrayList();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("select * from kody_rabatowe ORDER BY id_rabatu DESC");
            PromoCode code;
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                code = new PromoCode(result.getInt("id_rabatu"),result.getString("kod"),result.getFloat("wartosc_rabatu"),result.getInt("ilosc_uzyc"));
                list.add(code);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }
}