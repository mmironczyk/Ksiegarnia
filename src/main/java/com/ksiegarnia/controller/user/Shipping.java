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
@WebServlet("/Shipping")
public class Shipping extends HttpServlet {
    /** Funkcja służąca do zapisywania danych po finalizacji zamówienia.
     * @see com.ksiegarnia.model.HistoryModel#jakiRabat
     * @see com.ksiegarnia.model.HistoryModel#Jakiklient
     * @see com.ksiegarnia.model.ProductModel#getProduct */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nr_zamowienia=request.getParameter("n");
        User u = new User();
        int id = new HistoryModel().Jakiklient(nr_zamowienia);
        u = new UserDbModel().getUser(id);
        request.setAttribute("usr",u);
        request.setAttribute("nr_z",nr_zamowienia);
        String nextJSP = "/shipping.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}