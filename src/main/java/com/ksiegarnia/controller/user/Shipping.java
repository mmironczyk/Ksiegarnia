package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.HistoryModel;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

/** Servlet odpowiedzialny za generowanie etykiety transportowej. */
@WebServlet("/Shipping")
public class Shipping extends HttpServlet {
    /** Funkcja służąca do utworzenia etykiety transportowej z danych wyciągnietych z bazy danych.
     * @see com.ksiegarnia.beans.User
     * @see com.ksiegarnia.model.HistoryModel#Jakiklient
     * @see com.ksiegarnia.model.UserDbModel#getUser
     */
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