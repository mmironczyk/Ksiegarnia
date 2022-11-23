package com.ksiegarnia.controller.admin;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import com.ksiegarnia.beans.Product;
import com.ksiegarnia.model.ProductModel;

@WebServlet("/admin/ServletAdProduct")
public class ServletAdProduct extends HttpServlet {

    List<Product> allProducts = new ArrayList<Product>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TEST");
        ProductModel productModel = new ProductModel();
        allProducts = productModel.getAllProduct();
        System.out.println(allProducts);
        request.setAttribute("allProductsAdmin", allProducts);
        String nextJSP = "/admin/adminPanelProducts.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }
}
