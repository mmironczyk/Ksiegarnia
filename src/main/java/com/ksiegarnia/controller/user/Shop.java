package com.ksiegarnia.controller.user;

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
/** Servlet zwracający listę produktów, zapisując do tabeli.*/
@WebServlet("/Shop")
public class Shop extends HttpServlet {

    List<Product> allProducts = new ArrayList<Product>();
/** Funkcja zwracająca listę produktów. 
 * @see com.ksiegarnia.model.ProductModel#getProduct
 * @see com.ksiegarnia.model.ProductModel#getAllProduct 
 * @see com.ksiegarnia.model.ProductModel#Search 
 * @see com.ksiegarnia.model.ProductModel#getAllProductByCategory */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        String szukanie = request.getParameter("szukanie");
        //-------------- handle paging ------------------
        int pageid = 1;
        int totalPerPage = 9;
        int start;
        String cate="";
        if (request.getParameter("page") != null) {
            pageid = Integer.parseInt(request.getParameter("page"));
        }
        start = (pageid - 1 )*totalPerPage;
        if(szukanie != null)
        {
            allProducts = productModel.Search(szukanie,start,totalPerPage);
            if(allProducts.size() < 0)
            {
            // Paginacja do zrobienia
            }
        }
        else if(request.getParameter("c") != null) {
             cate = request.getParameter("c");
            allProducts = productModel.getAllProductByCategory(cate,start,totalPerPage);
        } else {
            allProducts = productModel.getAllProduct(start, totalPerPage);
        }
        int noOfRecords = productModel.getRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / totalPerPage);
        request.setAttribute("allProducts", allProducts);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", pageid);
        request.setAttribute("query" , request.getParameter("c"));
        String nextJSP = "/mainProductsPage.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
