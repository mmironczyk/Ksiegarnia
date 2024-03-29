package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
/** servlet obsługujący zmiane imienia i nazwiska użytkownika */
@WebServlet(name = "ChangePersonals", value = "/user/ChangePersonals")
public class ChangePersonals extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /** funkcja która pozwala na zmiane nazwiska oraz imienia w ustawieniach
     * @see com.ksiegarnia.model.UserDbModel#zmiana_danych 
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("LoginUser");
        try {
            new UserDbModel().zmiana_danych(imie, nazwisko,user);
            getServletContext().getRequestDispatcher("/logout").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
