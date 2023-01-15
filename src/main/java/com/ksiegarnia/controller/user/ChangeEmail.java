package com.ksiegarnia.controller.user;
/** servlet obsługujący zmiane emailu przez użytkownika */
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ChangeEmail", value = "/user/ChangeEmail")
public class ChangeEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /** funkcja pozwalająca na zmianę emaila przez użytkownika na nowy
     * @see com.ksiegarnia.model.UserDbModel#zmiana_email
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("LoginUser");
        try {
            new UserDbModel().zmiana_email(email,user);
            getServletContext().getRequestDispatcher("/logout").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
