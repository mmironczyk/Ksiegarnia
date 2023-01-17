package com.ksiegarnia.model;

import com.ksiegarnia.beans.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Model dla historii zamówień i płatności */
public class HistoryModel {
    ResultSet result;
    PreparedStatement pst = null;
    DbConnection db = new DbConnection();
    Connection con;

    /** Funkcja wyszukująca wszystkie produkty dotyczące danego zamówienia z bazy danych
     * @param nr Numer Zamówienia
     * @return Funkcja zwraca <b>ArrayList-e</b> obiektów klasy <b>Product</b>.
     * @see com.ksiegarnia.beans.Product
     * */
    public ArrayList<Product> listaprod(String nr)
    {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from zamowienia Where nr_zamowienia=?");
            pst.setString(1, nr);
            result = pst.executeQuery();
            Product p;
            while (result.next()) {
                p=new Product();
                p.setProductId(result.getInt("id_produktu"));
                p.setAmount(result.getInt("ilosc_produktu"));
                p.setCost(result.getFloat("cena_sztuka"));
                list.add(p);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    /** Funkcja wyszukująca właściciela danego zamówienia z bazy danych
     * @param nr Numer Zamówienia
     * @return Funkcja zwraca <b>id</b> właściciela danego zamówienia
     * */
    public int Jakiklient(String nr) {
        int id=0;
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from zamowienia Where nr_zamowienia=?");
            pst.setString(1, nr);
            result = pst.executeQuery();
            while (result.next()) {
                id=result.getInt("id_klienta");
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return id;
    }

    /** Funkcja wyszukująca rabat dla danego zamówienia z bazy danych
     * @param nr Numer Zamówienia
     * @return Funkcja zwraca <b>wartość rabatu</b> dla danego zamówienia
     * */
    public float jakiRabat(String nr)
    {
        float rabat=0;
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from platnosci Where nr_zamowienia=?");
            pst.setString(1, nr);
            result = pst.executeQuery();
            while (result.next()) {
                rabat=result.getFloat("rabat_procent");
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return rabat;
    }
}
