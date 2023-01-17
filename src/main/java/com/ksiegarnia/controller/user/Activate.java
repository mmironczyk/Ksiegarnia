package com.ksiegarnia.controller.user;

import com.ksiegarnia.model.UserDbModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Activate")
public class Activate extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("r");
        Boolean test=false;
        try {
             test = new UserDbModel().aktywuj(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("wynik", test);
        System.out.println("test");
        String nextJSP = "/activation.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
