package com.ksiegarnia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Klasa związana z obsługą połączenia z bazą danych */
public class DbConnection {
    Connection con = null;
    final private String url;
    final private String user;
    final private String pass;

    public DbConnection() {
        url = "jdbc:mariadb://localhost/bookstore";
        user = "root";
        pass = "123123";
    }

    /** Funkcja otwiera połączenia z bazą danych przy pomocy sterownika MariaDB Connector */
    public Connection openConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            return con;
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /** Funkcja zamyka połączenia z bazą danych
     * @return Funkcja zwraca <b>true</b> jeśli poprawnie zamknięto połączenie, w przeciwnym razie zwraca <b>false</b>.
     * */
    public boolean closeConnection() {
        try {
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
