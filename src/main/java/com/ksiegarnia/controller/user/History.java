package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.Product;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.HistoryModel;
import com.ksiegarnia.model.ProductModel;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;

/** Servlet historii. */
@WebServlet("/History")
public class History extends HttpServlet {
/** Funkcja służąca do zapisywania danych po finalizacji zamówienia.
 * @see com.ksiegarnia.model.HistoryModel#jakiRabat
 * @see com.ksiegarnia.model.HistoryModel#Jakiklient
 * @see com.ksiegarnia.model.ProductModel#getProduct */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nr_zamowienia=request.getParameter("n");
        ArrayList<Product> pr = new ArrayList<>();
        ArrayList<Product> pr2 = new ArrayList<>();
        HistoryModel model = new HistoryModel();
        pr = model.listaprod(nr_zamowienia);
        ProductModel model2 = new ProductModel();
        for(int x=0;x<pr.size();x++)
        {
            Product p = model2.getProduct(pr.get(x).getProductId());
            p.setAmount(pr.get(x).getAmount());
            p.setCost(pr.get(x).getCost());
            pr2.add(p);
        }
        User u = new User();
        int id = new HistoryModel().Jakiklient(nr_zamowienia);
        u = new UserDbModel().getUser(id);
        float rabat = new HistoryModel().jakiRabat(nr_zamowienia);

        request.setAttribute("usr",u);
        request.setAttribute("carts",pr2);
        request.setAttribute("rabat",rabat);
        request.setAttribute("nr_z",nr_zamowienia);
        String nextJSP = "/history.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}