package com.ksiegarnia.controller.admin;

import java.io.IOException;

import com.ksiegarnia.tools.FileUpload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.Product;
import com.ksiegarnia.model.ProductModel;
import jakarta.servlet.http.Part;

@WebServlet(name = "ManageProduct", urlPatterns = {"/admin/ManageProduct"})
@MultipartConfig
public class ManageProduct extends HttpServlet {

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
            request.getRequestDispatcher("productedit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        double cost = Double.parseDouble(request.getParameter("cena"));
        String gatunek = request.getParameter("gatunek");
        String date = request.getParameter("data");
        String author = request.getParameter("Autor");
        String description = request.getParameter("Description");
        int id = Integer.parseInt(request.getParameter("idt"));
        int amount = Integer.parseInt(request.getParameter("Amount"));
        int pages = Integer.parseInt(request.getParameter("pages"));

        Product productObj = new Product();
        productObj.setProductId(id);
        productObj.setTitle(title);
        productObj.setCost(cost);
        productObj.setCategory(gatunek);
        productObj.setDate(date);
        productObj.setDescription(description);
        productObj.setAmount(amount);
        productObj.setPages(pages);
        productObj.setAuthor(author);

        new ProductModel().editProduct(productObj);
        System.out.println("EDYCJA"+gatunek);
        response.sendRedirect("ServletAdProduct");

    }
}
