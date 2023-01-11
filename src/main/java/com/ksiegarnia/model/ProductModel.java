package com.ksiegarnia.model;

import com.ksiegarnia.beans.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductModel {
    ResultSet result;
    PreparedStatement pst = null;
    DbConnection db = new DbConnection();
    private int nRecords ;
    Connection con;
    public boolean addProduct(Product product) {
        int i = 0;
        try {
            con = db.openConnection();
            System.out.println(con);
            pst = con.prepareStatement("insert into ksiazki(tytul,cena,ilosc_sztuk,ilosc_stron,data_wydania,opis,autor,okladka,gatunek) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, product.getTitle());
            pst.setDouble(2, product.getCost());
            pst.setInt(3, product.getAmount());
            pst.setInt(4, product.getPages());
            pst.setString(5, product.getDate());
            pst.setString(6, product.getDescription());
            pst.setString(7, product.getAuthor());
            pst.setString(8, product.getImage());
            pst.setString(9, product.getCategory());
            i = pst.executeUpdate();
            db.closeConnection();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return false;
    }
    public boolean editProduct(Product product) {
        try {
            con = db.openConnection();
            pst = con.prepareStatement("update ksiazki set tytul=?,cena=?,ilosc_sztuk=?,ilosc_stron=?,data_wydania=?,opis=?,gatunek=? where id_ksiazki=?");
            pst.setString(1, product.getTitle());
            pst.setDouble(2, product.getCost());
            pst.setInt(3, product.getAmount());
            pst.setInt(4, product.getPages());
            pst.setString(5, product.getDate());
            pst.setString(6, product.getDescription());
            pst.setString(7, product.getCategory());
            pst.setInt(8, product.getProductId());
            pst.executeUpdate();
            db.closeConnection();
            System.out.println("Edytowano");
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return false;

    }

    public boolean deleteProduct(int id,String path) {
        try {
            int i = 0;
            Product product = getProduct(id);
            boolean deleteFile = com.ksiegarnia.tools.FileUpload.deleteFile(product.getImage(),path);
            if (deleteFile) {
                con = db.openConnection();
                pst = con.prepareStatement("delete from ksiazki where id_ksiazki=?");
                pst.setInt(1, id);
                i = pst.executeUpdate();
                db.closeConnection();
                if (i > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return false;
    }
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki ORDER BY id_ksiazki DESC");
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                list.add(p);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }
    public Product getProduct(int productId) {
        Product productObject = new Product();// to return value of select
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki  where id_ksiazki=?");
            pst.setInt(1, productId);
            result = pst.executeQuery();
            if (result.next()) {
                productObject.setTitle(result.getString("tytul"));
                productObject.setProductId(result.getInt("id_ksiazki"));
                productObject.setCost(result.getDouble("cena"));
                productObject.setAmount(result.getInt("ilosc_sztuk"));
                productObject.setPages(result.getInt("ilosc_stron"));
                productObject.setDescription(result.getString("opis"));
                productObject.setDate(result.getString("data_wydania"));
                productObject.setAuthor(result.getString("autor"));
                productObject.setImage(result.getString("okladka"));
                productObject.setCategory(result.getString("gatunek"));
                db.closeConnection();
                return productObject;
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }

        return null;
    }
    public ArrayList<Product> getLastProduct() {
        ArrayList<Product> selectLastProduct = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki ORDER BY id_ksiazki DESC LIMIT 6 ");
            Product obj;
            result = pst.executeQuery();
            while (result.next()) {
                obj = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                selectLastProduct.add(obj);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(selectLastProduct.size());
        return selectLastProduct;
    }
    public ArrayList<Product> getProductByTitle(String title) {
        ArrayList<Product> ListProductByName = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("SELECT * FROM ksiazki WHERE tytul LIKE ? ESCAPE '!'");
            title = title.replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            pst.setString(1, title + "%");
            Product obj;
            result = pst.executeQuery();
            while (result.next()) {
                obj = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                ListProductByName.add(obj);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(ListProductByName.size());
        return ListProductByName;
    }

    public ArrayList<Product> getAllProductByCategoryId(String category) {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki where gatunek=? ");
            pst.setString(1, category);
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                list.add(p);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }
    public ArrayList<Product> getRecommeendedItem(String category, int productid) {
        ArrayList<Product> getItem = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("SELECT * from ksiazki where id_ksiazki <> ? and gatunek= ? ORDER BY id_ksiazki ASC limit 6");
            pst.setInt(1, productid);
            pst.setString(2, category);
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                getItem.add(p);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(getItem.size());
        return getItem;
    }
    public boolean zakup(int liczba, int id) throws SQLException {
        con = db.openConnection();
        int i = 0;
        pst = con.prepareStatement("update ksiazki set ilosc_sztuk=ilosc_sztuk-? where id_ksiazki=?");
        pst.setInt(1, liczba);
        pst.setInt(2, id);
        i = pst.executeUpdate();
        db.closeConnection();
        if (i > 0) {
            return true;
        }
        return false;
    }
    public ArrayList<Product> getAllProductByPrice(double start, double end) {
        ArrayList<Product> getAllProductByPrice = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki where cena BETWEEN ? AND ?");
            pst.setDouble(1, start);
            pst.setDouble(2, end);
            Product product;
            result = pst.executeQuery();
            while (result.next()) {
                product = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                getAllProductByPrice.add(product);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(getAllProductByPrice.size());
        return getAllProductByPrice;
    }
    public ArrayList<Product> getAllProduct(int start , int limit) {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki ORDER BY id_ksiazki DESC LIMIT ? , ?");
            pst.setInt(1, start);
            pst.setInt(2, limit);
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                list.add(p);
            }
            result = con.prepareStatement("SELECT count(*) FROM ksiazki").executeQuery();
            if(result.next()){
                this.nRecords = result.getInt(1);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    public List<Product> getAllProductByCategory(String category, int start , int limit) {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki where gatunek=? ORDER BY id_ksiazki DESC LIMIT ? , ?");
            pst.setString(1, category);
            pst.setInt(2, start);
            pst.setInt(3, limit);
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                list.add(p);
            }
            pst = con.prepareStatement("SELECT count(*) FROM ksiazki where gatunek=?");
            pst.setString(1, category);
            result = pst.executeQuery();
            if(result.next()){
                this.nRecords = result.getInt(1);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    public int getRecords() {
        return nRecords;
    }

    public double getMaxProductByPrice( ) {
        double Hprice=0;
        try {
            con = db.openConnection();
            pst = con.prepareStatement("SELECT MAX(cena) AS Hprice FROM ksiazki");
            result = pst.executeQuery();
            if (result.next()) {
                Hprice = result.getDouble("Hprice");
                db.closeConnection();
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return  Hprice;
    }

    public List<Product> Search(String title, int start , int limit) {
        ArrayList<Product> list = new ArrayList();
        try {
            con = db.openConnection();
            pst = con.prepareStatement("select * from ksiazki where tytul Like ? ORDER BY id_ksiazki DESC LIMIT ? , ?");
            pst.setString(1, '%'+title+'%');
            pst.setInt(2, start);
            pst.setInt(3, limit);
            Product p;
            result = pst.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("tytul"),result.getDouble("cena"),result.getString("okladka"),result.getString("opis"),
                        result.getString("data_wydania"),result.getInt("ilosc_sztuk"),result.getInt("ilosc_stron"),result.getInt("id_ksiazki"),result.getString("gatunek"));
                list.add(p);
            }
        } catch (SQLException ex) {
            db.closeConnection();
            ex.printStackTrace();
        }
        return list;
    }



}
