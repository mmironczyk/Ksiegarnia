package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
/** servlet obsługujący zmiane addresu przez użytkownika (miasto,kod,ulica) */
@WebServlet(name = "ChangeAddres", value = "/user/ChangeAddres")
public class ChangeAddres extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /** funkcja pozwalająca na zmianę adresu przez użytkownika (miasto,kod,ulica)
     * @see com.ksiegarnia.model.UserDbModel#zmiana_adresu
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String miasto = request.getParameter("miasto");
        String kod = request.getParameter("kod");
        String ulica = request.getParameter("ulica");


        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("LoginUser");
        try {
            new UserDbModel().zmiana_adresu(miasto,kod,ulica,user);
            getServletContext().getRequestDispatcher("/logout").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
