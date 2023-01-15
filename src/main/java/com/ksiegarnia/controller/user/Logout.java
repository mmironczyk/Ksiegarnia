package com.ksiegarnia.controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/** Servlet odpowiedzialny za kończenie sesji użytkownika. */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {

    /** Funkcja kończąca sesję użytkownika, przekierowując go na stronę główną. */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession(false).invalidate();
        response.sendRedirect("index.jsp");
    }
    /** Funkcja kończąca sesję użytkownika, przekierowując go na stronę główną. */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession(false).invalidate();
        response.sendRedirect("index.jsp");
    }
}
