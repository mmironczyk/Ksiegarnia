package com.ksiegarnia.model;

import com.ksiegarnia.beans.OrderRecord;
import com.ksiegarnia.beans.Reservation;
import com.ksiegarnia.beans.ReservationRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationModel extends DbConnection{


    ResultSet result;
    PreparedStatement pst = null;
    DbConnection db = new DbConnection();
    private int nRecords ;
    Connection con;



    public boolean addReservation(Reservation res) {

        try {
            con = openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("INSERT INTO rezerwacje(id_klienta,id_produktu,ilosc,expire_date) VALUES (?,?,?,?)");
            pst.setInt(1, res.getUserId());
            pst.setInt(2, res.getProductId());
            pst.setInt(3, res.getQuantity());
            pst.setDate(4, res.getExpire_date());
            int executeUpdate = pst.executeUpdate();
            closeConnection();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void zarezerwuj(int liczba, int id) throws SQLException {
        con = db.openConnection();
        int i = 0;
        pst = con.prepareStatement("update ksiazki set ilosc_sztuk=ilosc_sztuk-? where id_ksiazki=?");
        pst.setInt(1, liczba);
        pst.setInt(2, id);
        i = pst.executeUpdate();
        db.closeConnection();
    }
    public ArrayList<ReservationRecord> allReservations(int id)
    {
        ArrayList<ReservationRecord> list = new ArrayList();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT r.id_rezerwacji,r.id_produktu,r.ilosc ,r.expire_date,k.tytul FROM rezerwacje as r , ksiazki as k WHERE r.id_produktu=k.id_ksiazki AND r.id_klienta=?");
            pst.setInt(1, id);
            result = pst.executeQuery();
            ReservationRecord res;
            while (result.next()) {
                res = new ReservationRecord(result.getInt("id_rezerwacji"),id,result.getInt("id_produktu"),result.getInt("ilosc"),result.getDate("expire_date"),result.getString("tytul"));
                list.add(res);
            }
            db.closeConnection();
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return list;
    }
    public boolean deleteReservation(int id) {
        con = openConnection();
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try {
            pst1 = con.prepareStatement("UPDATE ksiazki,rezerwacje SET ksiazki.ilosc_sztuk=ksiazki.ilosc_sztuk+rezerwacje.ilosc WHERE rezerwacje.id_rezerwacji=? AND ksiazki.id_ksiazki=rezerwacje.id_produktu;");
            pst1.setInt(1, id);
            int executeUpdate1 = pst1.executeUpdate();
            pst2 = con.prepareStatement("DELETE FROM rezerwacje WHERE id_rezerwacji=?");
            pst2.setInt(1, id);
            int executeUpdate2 = pst2.executeUpdate();
            closeConnection();
            return true;
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
