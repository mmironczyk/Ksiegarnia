package com.ksiegarnia.controller.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.Product;
import com.ksiegarnia.model.ProductModel;

@WebServlet(name = "DeleteProduct", urlPatterns = {"/admin/DeleteProduct"})
@MultipartConfig
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Product productobject = new ProductModel().getProduct(id);
        String path = request.getServletContext().getRealPath("");
        if (productobject == null) {
            request.getSession().setAttribute("message", "Nie znaleziono książki");
            response.sendRedirect("../../failed.jsp");
        } else {
            request.setAttribute("product", productobject);
            new ProductModel().deleteProduct(id,path);
            response.sendRedirect("ServletAdProduct");
        }
    }
}
