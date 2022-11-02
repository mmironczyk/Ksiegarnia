package com.ksiegarnia.model;

import com.ksiegarnia.beans.User;
import java.sql.*;
import com.ksiegarnia.tools.SHA;

public class UserDbModel {
    User bean = new User();
    Connection con;
    DbConnection db = new DbConnection();
    boolean b = false;
    private boolean search(String login) {

        try {
            con = db.openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * from users where (login=?)");
            pst.setString(1, login);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                b = true;
            } else {
                b = false;
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return b;
    }
    public User signIn(String login, String password) {
        System.out.println(SHA.encrypt(password));
        User userSignIn = null;
        try {
            if (search(login)) {
                con = db.openConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * from users where (login=?) and (haslo=?)");
                pst.setString(1, login);
                pst.setString(2, SHA.encrypt(password));
                ResultSet result = pst.executeQuery();
                if (result.next()) {
                    userSignIn = new User();
                    userSignIn.setUserId(result.getInt("id"));
                    userSignIn.setLogin(result.getString("login"));
                    userSignIn.setEmail(result.getString("email"));
                    userSignIn.setHaslo("");
                }
                db.closeConnection();
                System.out.println("zalogowano");
                return userSignIn;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            db.closeConnection();
        }
        return null;
    }

    public boolean signUp(User bean) {

        boolean b = false;


        if (!search(bean.getLogin())) {
            try {
                con = db.openConnection();
                PreparedStatement pst1 = con.prepareStatement("INSERT into users (login,haslo,email)"
                        + "values (?,?,?)");
                pst1.setString(1, bean.getLogin());
                pst1.setString(2, SHA.encrypt(bean.getHaslo()));
                pst1.setString(3, bean.getEmail());
                pst1.executeUpdate();

                PreparedStatement pst2 = con.prepareStatement("INSERT into klienci (login,imie,nazwisko,miejscowosc,kod_pocztowy,ulica,nr_telefonu)"
                        + "values (?,?,?,?,?,?,?)");
                pst2.setString(1, bean.getLogin());
                pst2.setString(2, bean.getImie());
                pst2.setString(3, bean.getNazwisko());
                pst2.setString(4, bean.getMiasto());
                pst2.setString(5, bean.getKod());
                pst2.setString(6, bean.getAdres());
                pst2.setString(7, bean.getTelefon());
                pst2.executeUpdate();

                pst1.close();
                pst2.close();
                b = true;

            } catch (SQLException e) {
                e.printStackTrace();
                return b ;
            }
        }
        return b;
    }

    public User getUser(int id) {
        User user = null ;
        try {

            con = db.openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * from users where (id=?)");
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                user= new User();
                user.setUserId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("email"));
                user.setImie(result.getString("imie"));
                user.setNazwisko(result.getString("nazwisko"));
                user.setMiasto(result.getString("miasto"));
                user.setAdres(result.getString("adres"));
                user.setHaslo("");
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return user ;
    }
}
