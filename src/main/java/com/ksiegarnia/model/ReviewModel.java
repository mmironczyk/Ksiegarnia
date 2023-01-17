package com.ksiegarnia.model;

import com.ksiegarnia.beans.Review;
import com.ksiegarnia.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * klasa reprezentująca model opinii
 */
public class ReviewModel extends DbConnection {
        ResultSet rs = null;
        Connection con;

    DbConnection db = new DbConnection();

    /**
     * funkcja pobierająca nowo-stworzoną opinię i dodawająca ją do bazy danych
     * @param review - dodawana opinia
     * @return Boolean - opisuje czy operacja została przeprowadzona pomyślnie
     */
    public boolean addReview(Review review) {
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("INSERT INTO opinie (id_klienta,id_oferty,opinia,zdjecie,link)VALUES (?,?,?,?,?)");
            pst.setInt(1, review.getUserId());
            pst.setInt(2, review.getProductId());
            pst.setString(3, review.getReviewText());
            pst.setString(4, review.getReviewImage());
            pst.setString(5, review.getLink());
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
    /**
     * funkcja pobiera obiekt opinii z nowymi danymi i przeprowadza operację UPDATE na opinii o tym samym ID
     * @param review - opinia zastępująca starą o tym samym ID
     * @return Boolean - opisuje czy operacja została przeprowadzona pomyślnie
     */
    public boolean editReview(Review review) {
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("UPDATE opinie SET opinia=?,link=? WHERE id_opinia=?");
            pst.setString(1, review.getReviewText());
            pst.setString(2, review.getLink());
            pst.setInt(3, review.getReviewId());
            pst.executeUpdate();
            db.closeConnection();

        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * funkcja pobiera ID opinii oraz ścieżkę do załączonego zdjęcia i usuwa je
     * funkcja zwraca boolean, który opisuje czy operacja została przeprowadzona pomyślnie
     * @param id - id opinii do usunięcia
     * @param path - ścieżka do zdjęcia załączonego do opinii
     * @return Boolean - opisuje czy operacja została przeprowadzona pomyślnie
     */
    public boolean deleteReview(int id, String path) {
        try {
            Review review = getReview(id);
            boolean deleteFile = com.ksiegarnia.tools.FileUpload.deleteFile(review.getReviewImage(), path);
            if (deleteFile) {
                con = db.openConnection();
                PreparedStatement pst = null;
                pst = con.prepareStatement("DELETE FROM opinie WHERE id_opinia=?");
                pst.setInt(1, id);
                int executeUpdate = pst.executeUpdate();
                db.closeConnection();
                if (executeUpdate > 0)
                    return true;
            }
        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * funkcja zwracająca wybraną opinię z bazy danych
     * @param id - id szukanej opinii
     * @return Review - zwracana znaleziona opinia
     */
    public Review getReview(int id) {
        Review review = new Review();
        try {
            con = db.openConnection();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM opinie WHERE id_opinia=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                review.setReviewId(rs.getInt("id_opinia"));
                review.setUserId(rs.getInt("id_klienta"));
                review.setProductId(rs.getInt("id_oferty"));
                review.setReviewText(rs.getString("opinia"));
                review.setReviewImage(rs.getString("zdjecie"));
                review.setLink(rs.getString("link"));
                db.closeConnection();
                return review;
            }

        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * funkcja pobierająca wszystkie metody utworzone przez danego użytkownika
     * @param userID - id użytkownika, którego opinie są pobierane
     * @return ArrayList - zwracana lista z opiniami użytkownika
     */
    public ArrayList<Review> getUserReviews(int userID) {
        try {
            con = db.openConnection();
            ArrayList<Review> array = new ArrayList<>();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM opinie WHERE id_klienta=?");
            pst.setInt(1, userID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setReviewId(rs.getInt("id_opinia"));
                review.setUserId(rs.getInt("id_klienta"));
                review.setProductId(rs.getInt("id_oferty"));
                review.setReviewText(rs.getString("opinia"));
                review.setReviewImage(rs.getString("zdjecie"));
                review.setLink(rs.getString("link"));
                array.add(review);
            }
            db.closeConnection();
            return array;

        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * funkcja pobierająca wszystkie opinie dla danego produktu
     * @param pID - id produktu, dla którego są pobierane opinie
     * @return ArrayList - zwracana lista z opiniami produktu
     */
    public ArrayList<Review> getProductReviews(int pID) {
        try {
            con = db.openConnection();
            ArrayList<Review> array = new ArrayList<>();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM opinie WHERE id_oferty=?");
            pst.setInt(1, pID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setReviewId(rs.getInt("id_opinia"));
                review.setUserId(rs.getInt("id_klienta"));
                review.setProductId(rs.getInt("id_oferty"));
                review.setReviewText(rs.getString("opinia"));
                review.setReviewImage(rs.getString("zdjecie"));
                review.setLink(rs.getString("link"));
                array.add(review);
            }
            db.closeConnection();
            return array;

        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * funkcja pobierająca wszytskie opinie będące w bazie danych
     * @return ArrayList - zwracana lista ze wszystkimi opiniami
     */
    public ArrayList<Review> getAllReviews() {
        try {
            con = db.openConnection();
            ArrayList<Review> array = new ArrayList<>();
            PreparedStatement pst = null;
            pst = con.prepareStatement("SELECT * FROM opinie");
            rs = pst.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setReviewId(rs.getInt("id_opinia"));
                review.setUserId(rs.getInt("id_klienta"));
                review.setProductId(rs.getInt("id_oferty"));
                review.setReviewText(rs.getString("opinia"));
                review.setReviewImage(rs.getString("zdjecie"));
                review.setLink(rs.getString("link"));
                array.add(review);
            }
            db.closeConnection();
            return array;

        } catch (Exception e) {
            db.closeConnection();
            e.printStackTrace();
            return null;
        }
    }
}
