package com.ksiegarnia.model;

import com.ksiegarnia.beans.User;
import java.sql.*;
import java.util.ArrayList;

import com.ksiegarnia.tools.SHA;
/** Model dla służący do zarządzania użytkownkiem */
public class UserDbModel {
    User bean = new User();
    Connection con;
    DbConnection db = new DbConnection();
    boolean b = false;
    /** Funkcja wyszukująca użytkowników po jego loginie
     * @param login login użytkownika
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * */
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
    /** Funkcja pozwalająca użytkownikowi na zalogowanie
     * @param login login użytkownika
     * @param password haslo użytkownika
     * @return Funkcja zwraca <b>userSignin</b> czyli dane użytkownika.
     * @see com.ksiegarnia.beans.User
     * */
    public User signIn(String login, String password) {
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
    /** Funkcja pozwalająca utworzyć uzytkownika
     * @param bean obiekt typu User
     * @param kodakt kod aktywacyjny
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * */
    public boolean signUp(User bean,String kodakt) {

        boolean b = false;
        if (!search(bean.getLogin())) {
            try {
                con = db.openConnection();
                PreparedStatement pst1 = con.prepareStatement("INSERT into users (login,haslo,email,typ,kod)"
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
    /** Funkcja zwracająca dane użykownika
     * @param id id użytkownika
     * @return Funkcja zwraca <b>user</b> czyli obiekt typu user
     * @see com.ksiegarnia.beans.User
     * */
    public User getUser(int id) {
        User user = null ;
        try {
            con = db.openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT u.id, u.login, u.email, k.imie, k.nazwisko, k.miejscowosc, k.ulica, k.kod_pocztowy, k.nr_telefonu from users as u, klienci as k Where u.login=k.login and u.id=?;");
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                user= new User();
                user.setUserId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("email"));
                user.setImie(result.getString("imie"));
                user.setNazwisko(result.getString("nazwisko"));
                user.setMiasto(result.getString("miejscowosc"));
                user.setAdres(result.getString("ulica"));
                user.setKod(result.getString("kod_pocztowy"));
                user.setTelefon(result.getString("nr_telefonu"));
                user.setHaslo("");
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return user ;
    }
    /** Funkcja pozwalająca na aktuwacje użytkownika
     * @param kodakt kod aktywacyjny
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wykonać polecenie SQL, w przeciwnym razie zwraca <b>false</b>.
     * */
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
    /** Funkcja zwracająca liste wszystkich userów
     * @return Funkcja zwraca <b>ArrayList-e</b> obiektów klasy <b>User</b>.
     * @see com.ksiegarnia.beans.User
     * */
    public ArrayList<User> getAllUsers() {
        con = db.openConnection();
        ArrayList<User> allUser = new ArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT u.id, u.login, u.email, k.imie, k.nazwisko, k.miejscowosc, k.ulica, k.kod_pocztowy, k.nr_telefonu from users as u, klienci as k Where u.login=k.login;");
            ResultSet result = pst.executeQuery();
            User user = null ;
            while (result.next()) {
                user= new User();
                user.setUserId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setEmail(result.getString("email"));
                user.setImie(result.getString("imie"));
                user.setNazwisko(result.getString("nazwisko"));
                user.setMiasto(result.getString("miejscowosc"));
                user.setAdres(result.getString("ulica"));
                user.setKod(result.getString("kod_pocztowy"));
                user.setTelefon(result.getString("nr_telefonu"));
                user.setHaslo("");
                allUser.add(user);
            }
            db.closeConnection();
            return allUser;
        } catch (SQLException ex) {
            ex.printStackTrace();
            db.closeConnection();
        }
        return null;
    }

    /** Funkcja pozwalająca na zmiane danych (imie i nazwisko)
     * @param imie imie użytkownika
     * @param nazwisko nazwisko użytkownika
     * @param user obiekt typu User
     * */
    public void zmiana_danych(String imie, String nazwisko, User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE klienci SET imie=?, nazwisko=? WHERE imie=? AND nazwisko=?");
        pst.setString(1, imie);
        pst.setString(2, nazwisko);
        pst.setString(3, user.getImie());
        pst.setString(4, user.getNazwisko());
        pst.executeQuery();
    }
    /** Funkcja pozwalająca na zmiane danych (haslo)
     * @param haslo haslo użytkownika
     * @param haslo2 nowe haslo użytkownika
     * @param user obiekt typu User
     * */
    public void zmiana_hasla(String haslo,String haslo2, User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE users SET haslo=? WHERE haslo=? AND login=?");
        pst.setString(1, SHA.encrypt(haslo2));
        pst.setString(2, SHA.encrypt(haslo));
        pst.setString(3, user.getLogin());
        pst.executeQuery();
    }
    /** Funkcja pozwalająca na zmiane danych (mail)
     * @param email email użytkownika
     * @param user obiekt typu User
     * */
    public void zmiana_email(String email, User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE users SET email=? WHERE email=? AND login=?");
        pst.setString(1, email);
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getLogin());
        pst.executeQuery();
    }
    /** Funkcja pozwalająca na zmiane danych (adres)
     * @param miasto miasto użytkownika
     * @param kod kod haslo użytkownika
     * @param ulica ulica użytkownika
     * @param user obiekt typu User
     * */
    public void zmiana_adresu(String miasto,String kod, String ulica, User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE klienci SET miejscowosc=? , kod_pocztowy=?, ulica=? WHERE login=?");
        pst.setString(1, miasto);
        pst.setString(2, kod);
        pst.setString(3, ulica);
        pst.setString(4, user.getLogin());
        pst.executeQuery();
    }
    /** Funkcja pozwalająca usunięcie użytkownika
     * @param user obiekt typu User
     * */
    public void DeleteUser(User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("DELETE FROM klienci WHERE login=?");
        pst.setString(1, user.getLogin());
        pst.executeQuery();
        PreparedStatement pst2 = con.prepareStatement("DELETE FROM users WHERE id=?");
        pst2.setInt(1, user.getUserId());
        pst2.executeQuery();
    }
    /** Funkcja pozwalająca aktywować użytkownika
     * @param user obiekt typu User
     * */
    public void ActivateUser(User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE users SET czy_aktywne=1 WHERE id=?");
        pst.setInt(1, user.getUserId());
        pst.executeQuery();
    }
    /** Funkcja pozwalająca usunąć blokade z konta użytkownika
     * @param user obiekt typu User
     * */
    public void ClearBlock(User user) throws SQLException {
        con = db.openConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE users SET blokada=0 WHERE id=?");
        pst.setInt(1, user.getUserId());
        pst.executeQuery();
    }

}
