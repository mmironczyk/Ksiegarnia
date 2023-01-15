package com.ksiegarnia.controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import com.ksiegarnia.beans.Product;
import com.ksiegarnia.model.ProductModel;
import com.ksiegarnia.tools.FileUpload;

/** Servlet odpowiedzialny za dodawanie nowych książek z poziomu panelu administratora do bazy danych */
@WebServlet(name = "AddProduct", urlPatterns = {"/admin/AdminProduct"})
@MultipartConfig
public class AddBook extends HttpServlet {

    /** Funkcja sprawdzająca id książki wybranej z poziomu panelu administratora
     * @see com.ksiegarnia.model.ProductModel#getProduct
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Product productobject = new ProductModel().getProduct(id);
        if (productobject == null) {
            request.getSession().setAttribute("message", "Nie znaleziono książki");
            response.sendRedirect("../../failed.jsp");
        } else {
            request.setAttribute("product", productobject);
            request.setAttribute("type", "Edit");
            request.getRequestDispatcher("../../pages/adminPanel/addproduct.jsp").forward(request, response);
        }
    }

    /** Funkcja dodająca książki z poziomu panelu administratora
     * @see com.ksiegarnia.model.ProductModel#addProduct 
     * @see com.ksiegarnia.beans.Product
     * @see com.ksiegarnia.tools.FileUpload#uploadImage
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        double cost = Double.parseDouble(request.getParameter("cena"));
        String gatunek = request.getParameter("gatunek");
        String date = request.getParameter("data");
        String author = request.getParameter("Autor");
        String description = request.getParameter("Description");
        int amount = Integer.parseInt(request.getParameter("Amount"));
        int pages = Integer.parseInt(request.getParameter("pages"));


        Product productObj = new Product();
        productObj.setTitle(title);
        productObj.setCost(cost);
        productObj.setCategory(gatunek);
        productObj.setDate(date);
        productObj.setDescription(description);
        productObj.setAmount(amount);
        productObj.setPages(pages);
        productObj.setAuthor(author);


        Part filePart = request.getPart("image");
        if (filePart.getSize() != 0) {
            String path = request.getServletContext().getRealPath("");
            try {
                String uploadedpath = FileUpload.uploadImage(filePart, path);
                productObj.setImage(uploadedpath);
            } catch (Exception ex) {
                ex.printStackTrace();
                request.getSession().setAttribute("AlertMessage", "Wybierz okładkę");
                request.getSession().setAttribute("AlertType", "danger");
                response.sendRedirect("ServletAdProduct");
                return;
            }

        } else {
            productObj.setImage("upload/test.png");
        }
        if (request.getParameter("id") != null && !request.getParameter("id").trim().equals("")) {
            int id = Integer.parseInt(request.getParameter("id"));
            productObj.setProductId(id);
            if (new ProductModel().addProduct(productObj)) {
                request.getSession().setAttribute("AlertMessage", "Dodano pozycję");
                request.getSession().setAttribute("AlertType", "success");
                response.sendRedirect("ServletAdProduct");
                return;
            } else {
                request.getSession().setAttribute("AlertMessage", "Nie udało się dodać pozycji");
                request.getSession().setAttribute("AlertType", "danger");
                response.sendRedirect("ServletAdProduct");
                return;
            }
        }
    }
}
