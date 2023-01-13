package com.ksiegarnia.model;

import com.ksiegarnia.beans.Order;
import com.ksiegarnia.beans.OrderRecord;
import com.ksiegarnia.beans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel {

    ResultSet rs = null;
    Connection con;

    DbConnection db = new DbConnection();

    public boolean addOrder(Order ord) {
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("INSERT INTO zamowienia(id_klienta,nr_zamowienia,id_produktu,ilosc_produktu,cena_sztuka) VALUES (?,?,?,?,?)");
            pst.setInt(1, ord.getId_klienta());
            pst.setString(2, ord.getNr_zamowienia());
            pst.setInt(3, ord.getId_produktu());
            pst.setInt(4, ord.getIlosc_produktu());
            pst.setFloat(5, ord.getCena_sztuka());
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
/** <p>Funkcja zwracająca wszystkie zamówienia danego użytkownika z bazy danych</p>
 *  @param id id użytkownika
 *
 * */
    public ArrayList<OrderRecord> allOrders(int id)
    {
        ArrayList<OrderRecord> list = new ArrayList();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT z.id_zamowienia,z.nr_zamowienia, p.kwota FROM zamowienia as z , platnosci as p WHERE z.id_klienta=? and z.nr_zamowienia=p.nr_zamowienia GROUP BY nr_zamowienia");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            OrderRecord ord;
            while (rs.next()) {
                ord = new OrderRecord(rs.getInt("id_zamowienia"),rs.getString("nr_zamowienia"),rs.getFloat("kwota"));
                list.add(ord);
            }
            db.closeConnection();
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<OrderRecord> allOrdersAdmin()
    {
        ArrayList<OrderRecord> list = new ArrayList();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT z.id_zamowienia,z.nr_zamowienia, p.kwota FROM zamowienia as z , platnosci as p WHERE z.nr_zamowienia=p.nr_zamowienia GROUP BY nr_zamowienia");
            rs = pst.executeQuery();
            OrderRecord ord;
            while (rs.next()) {
                ord = new OrderRecord(rs.getInt("id_zamowienia"),rs.getString("nr_zamowienia"),rs.getFloat("kwota"));
                list.add(ord);
            }
            db.closeConnection();
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return list;
    }


}