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
            PreparedStatement pst = con.prepareStatement("SELECT * from users where (login=?) and blokada=0 and czy_aktywne=1");
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
                    userSignIn.setRola(result.getString("typ"));
                    userSignIn.setEmail(result.getString("email"));
                    userSignIn.setHaslo("");
                    PreparedStatement pst3 = con.prepareStatement("SELECT * from klienci where (login=?)");
                    pst3.setString(1, login);
                    ResultSet result2 = pst3.executeQuery();
                    if (result2.next()) {
                        userSignIn.setImie(result2.getString("imie"));
                        userSignIn.setNazwisko(result2.getString("nazwisko"));
                        userSignIn.setMiasto(result2.getString("miejscowosc"));
                        userSignIn.setKod(result2.getString("kod_pocztowy"));
                        userSignIn.setTelefon(result2.getString("nr_telefonu"));
                        userSignIn.setAdres(result2.getString("ulica"));
                    }
                    PreparedStatement pst2 = con.prepareStatement("UPDATE users SET liczba_prob=0 where (login=?)");
                    pst2.setString(1, login);
                    pst2.executeQuery();
                    db.closeConnection();
                    System.out.println("zalogowano");
                }
                else
                {
                    con = db.openConnection();
                    PreparedStatement pst3 = con.prepareStatement("UPDATE users SET liczba_prob=liczba_prob+1 where (login=?)");
                    pst3.setString(1, login);
                    pst3.executeQuery();
                }
                return userSignIn;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            db.closeConnection();
        }
        return null;
    }

    public boolean signUp(User bean,String kodakt) {

        boolean b = false;
        if (!search(bean.getLogin())) {
            try {
                con = db.openConnection();
                PreparedStatement pst1 = con.prepareStatement("INSERT into users (login,haslo,typ,email,kod)"
                        + "values (?,?,?,?,?)");
                pst1.setString(1, bean.getLogin());
                pst1.setString(2, SHA.encrypt(bean.getHaslo()));
                pst1.setString(3, bean.getEmail());
                pst1.setString(4, "user");
                pst1.setString(5, kodakt);
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
    public boolean aktywuj(String kodakt) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE czy_aktywne=0 AND (kod=?)");
        pst.setString(1, kodakt);
        ResultSet result = pst.executeQuery();
        if(result.next()) {
            PreparedStatement pst2 = con.prepareStatement("UPDATE users SET czy_aktywne=1 where (kod=?)");
            pst2.setString(1, kodakt);
            pst2.executeQuery();
            return true;
        }
        else
        {
            return false;
        }
    }
}
