package com.ksiegarnia.model;

import com.ksiegarnia.beans.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
