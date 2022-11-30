package com.ksiegarnia.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    Connection con = null;
    final private String url;
    final private String user;
    final private String pass;

    public DbConnection() {
        url = "jdbc:mariadb://localhost/bookstore";
        user = "root";
        pass = "root";
    }

    public Connection openConnection() {
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            //connect to DB
            con = DriverManager.getConnection(
                    url,
                    user,
                    pass);

            System.out.println(con);
            return con;
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
