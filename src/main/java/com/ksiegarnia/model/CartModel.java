package com.ksiegarnia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ksiegarnia.beans.Cart;
import com.ksiegarnia.beans.ProductinCart;

public class CartModel extends DbConnection {

    ResultSet rs = null;

    Connection con;

    public ArrayList<Cart> getUserCart(int userId) {

        try {

            con = openConnection();
            ArrayList<Cart> array = new ArrayList<>();
            PreparedStatement pst = null;
            pst = con.prepareStatement("select * From koszyk Where id_klient=?");
            pst.setInt(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("id_koszyka"));
                cart.setUserId(rs.getInt("id_klient"));
                cart.setProductId(rs.getInt("id_produkt"));
                cart.setQuantity(rs.getInt("ilosc"));
                array.add(cart);
            }
            closeConnection();
            return array;
        } catch (SQLException ex) {
            closeConnection();
            ex.printStackTrace();
            return null;
        } finally {
            closeConnection();
        }
    }

    public boolean addCart(Cart cart) {

        try {
            int search = search(cart.getProductId(), cart.getUserId());
            System.out.println("Serach -- " + search);
            if (search != 0) {
                System.out.println("In edit");
                return editQantity(search + cart.getQuantity(), cart.getUserId(), cart.getProductId());
            }
            System.out.println("Not Edit");
            con = openConnection();
            PreparedStatement pst = null;
            System.out.println("my con" + con);
            pst = con.prepareStatement("insert into koszyk (id_koszyka,id_klient,id_produkt,ilosc)Values (?,?,?,?)");
            pst.setInt(1, cart.getCartId());
            pst.setInt(2, cart.getUserId());
            pst.setInt(3, cart.getProductId());
            pst.setInt(4, cart.getQuantity());
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

    public boolean deleteCart(int cartID) {
        con = openConnection();
        PreparedStatement pst = null;
        try {
            //System.out.println("my con" + con);
            pst = con.prepareStatement("delete From koszyk where id_koszyka=?");
            pst.setInt(1, cartID);
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

    public boolean deleteUserCart(int userID) {
        con = openConnection();
        PreparedStatement pst = null;
        try {
            //System.out.println("my con" + con);
            pst = con.prepareStatement("delete From koszyk where id_klient=?");
            pst.setInt(1, userID);
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

    private int search(int pID, int usrID) {
        int qu = 0;
        try {

            con = openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * from koszyk where (id_produkt=?) and (id_klient=?)");
            pst.setInt(1, pID);
            pst.setInt(2, usrID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                qu = rs.getInt("ilosc");
            }
            closeConnection();
        } catch (SQLException ex) {
            closeConnection();
            ex.printStackTrace();
        }

        return qu;

    }

    private boolean editQantity(int quantity, int usrID, int productID) {
        try {

            con = openConnection();
            PreparedStatement pst = con.prepareStatement("Update koszyk set ilosc=? where id_klient=? and id_produkt=? ");
            pst.setInt(1, quantity);
            pst.setInt(2, usrID);
            pst.setInt(3, productID);

            int x = pst.executeUpdate();
            closeConnection();
            if (x > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            closeConnection();
        }
        return false;
    }

    public int getNubmberOfCartsForUser(int usrID) {

        int count = 0;
        ArrayList<Cart> userCart = getUserCart(usrID);
        for (int i = 0; i < userCart.size(); i++) {
            count += userCart.get(i).getQuantity();
            System.out.println("size ==" + userCart.size());
        }
        System.out.println("Quantity ==  " + count);
        return count;
    }

    public ArrayList<ProductinCart> getProductFromCart(int userId) {
        ArrayList<ProductinCart> carts = new ArrayList<ProductinCart>();
        try {
            con = openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT c.id_koszyka,c.ilosc,k.tytul,k.cena,k.okladka,k.opis,k.gatunek,k.id_ksiazki from koszyk as c, ksiazki as k where c.id_produkt=k.id_ksiazki AND c.id_klient=? ");
            pst.setInt(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                ProductinCart cartProduct = new ProductinCart();
                cartProduct.setCartId(rs.getInt("c.id_koszyka"));
                cartProduct.setAmount(rs.getInt("c.ilosc"));
                cartProduct.setTitle(rs.getString("k.tytul"));
                cartProduct.setCost(rs.getFloat("k.cena"));
                cartProduct.setImage(rs.getString("k.okladka"));
                cartProduct.setDescription(rs.getString("k.opis"));
                cartProduct.setCategory(rs.getString("k.gatunek"));
                cartProduct.setProductId(rs.getInt("k.id_ksiazki"));
                carts.add(cartProduct);
            }
            closeConnection();
            return carts;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Cart getCart(int cartID) {
        Cart qu = null;
        try {

            con = openConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * from koszyk where id_koszyka=?");
            pst.setInt(1, cartID);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                qu = new Cart();
                qu.setQuantity(rs.getInt("ilosc"));
                qu.setCartId(rs.getInt("id_koszyka"));
                qu.setProductId(rs.getInt("id_produkt"));
                qu.setUserId(rs.getInt("id_klient"));
            }
            closeConnection();
        } catch (SQLException ex) {
            closeConnection();
            ex.printStackTrace();
        }

        return qu;

    }

    public boolean reduceQuantity(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            int quantity = cart.getQuantity();
            if (quantity < 2) {
                return deleteCart(cartID);
            } else {
                System.out.println(quantity);
                con = openConnection();
                PreparedStatement pst = null;
                try {
                    pst = con.prepareStatement("update koszyk set ilosc=? where id_koszyka=? ");
                    pst.setInt(1,cart.getQuantity()-1);
                    pst.setInt(2, cartID);
                    int executeUpdate = pst.executeUpdate();
                    closeConnection();
                    if (executeUpdate > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;

    }

    public boolean increaseQuantity(int cartID) {
        Cart cart = getCart(cartID);
        if (cart != null) {
            int quantity = cart.getQuantity();
            if (quantity < 1) {
                return deleteCart(cartID);
            } else {
                con = openConnection();
                PreparedStatement pst = null;
                try {
                    //System.out.println("my con" + con);
                    pst = con.prepareStatement("update koszyk set ilosc=? where id_koszyka=? ");
                    pst.setInt(1, cart.getQuantity() + 1);
                    pst.setInt(2, cartID);
                    int executeUpdate = pst.executeUpdate();
                    closeConnection();
                    if (executeUpdate > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    closeConnection();
                    ex.printStackTrace();
                }
            }

        }
            return false;

        }

}



