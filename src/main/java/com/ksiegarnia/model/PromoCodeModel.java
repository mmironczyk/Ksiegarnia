package com.ksiegarnia.model;

import com.ksiegarnia.beans.PromoCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromoCodeModel {

    ResultSet rs = null;
    Connection con;

    DbConnection db = new DbConnection();

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
                code.setValue(rs.getDouble("wartosc_rabatu"));
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

    public ArrayList<PromoCode> getAllCodes() {
        ArrayList<PromoCode> list = new ArrayList();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("select * from kody_rabatowe ORDER BY id_rabatu DESC");
            PromoCode code;
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                code = new PromoCode(result.getInt("id_rabatu"),result.getString("kod"),result.getDouble("wartosc_rabatu"),result.getInt("ilosc_uzyc"));
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