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

/** Servlet odpowiedzialny za usuwanie blokady konta z poziomu panelu administratora */
@WebServlet(name = "ClearBlock", urlPatterns = {"/admin/ClearBlock"})
@MultipartConfig
public class ClearBlock extends HttpServlet {

    /** Usuwa blokadę konta poprzez otrzymany parametr id danego użytkownika 
     * @see com.ksiegarnia.model.UserDbModel#ClearBlock
     * @see com.ksiegarnia.model.UserDbModel#getUser
     * */
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
                new UserDbModel().ClearBlock(usr);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("ServletAdUser");
        }
    }
}
