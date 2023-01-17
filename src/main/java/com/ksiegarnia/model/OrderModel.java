package com.ksiegarnia.model;

import com.ksiegarnia.beans.Order;
import com.ksiegarnia.beans.OrderRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/** Model do obsługi zamówień */
public class OrderModel {

    ResultSet rs = null;
    Connection con;
    DbConnection db = new DbConnection();

    /** Funkcja dodająca zamówienie do bazy danych
     * @param ord Obiekt klasy Order zawierający zamówienie
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * @see com.ksiegarnia.beans.Order
     * */
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
    /** Funkcja zwracająca ArrayList-ę wszystkich zamówień danego użytkownika
     * @param id id danego użytkownika
     * @return Funkcja zwraca <b>ArrayList-e</b> obiektów klasy <b>OrderRecord</b> reprezentującą historię zamówień konkretnego użytkownika
     * @see com.ksiegarnia.beans.OrderRecord
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
    /** Funkcja zwracająca ArrayList-ę wszystkich zamówień wszystkich użytkowników. Przeznaczona dla Admina.
     * @return Funkcja zwraca <b>ArrayList-e</b> obiektów klasy <b>OrderRecord</b> reprezentującą historię zamówień wszystkich użytkowników
     * @see com.ksiegarnia.beans.OrderRecord
     * */
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