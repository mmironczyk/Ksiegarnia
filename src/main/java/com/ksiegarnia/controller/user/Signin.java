package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new UserDbModel().signIn(username, password);
           if(user == null ){
               request.setAttribute("message", "Nie można się zalogować.");
               getServletContext().getRequestDispatcher("/failed.jsp").forward(request, response);
           } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("LoginUser", user);
            session.setMaxInactiveInterval(60*15);
                   response.sendRedirect("index.jsp");
               }
           }
}
