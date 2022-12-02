package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ChangePassword", value = "/user/ChangePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String haslo = request.getParameter("haslostare");
        String haslo2= request.getParameter("haslo");

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("LoginUser");
        try {
            new UserDbModel().zmiana_hasla(haslo,haslo2,user);
            getServletContext().getRequestDispatcher("/logout").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

