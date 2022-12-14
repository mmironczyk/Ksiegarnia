package com.ksiegarnia.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "ActivateUser", urlPatterns = {"/admin/ActivateUser"})
@MultipartConfig
public class ActivateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User usr = new UserDbModel().getUser(id);
        if (usr == null) {
            request.getSession().setAttribute("message", "Nie znaleziono użytkownika");
            response.sendRedirect("../../failed.jsp");
        } else {
            request.setAttribute("product", usr);
            try {
                new UserDbModel().ActivateUser(usr);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("ServletAdUser");
        }
    }
}
