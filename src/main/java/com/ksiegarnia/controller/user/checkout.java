package com.ksiegarnia.controller.user;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import com.ksiegarnia.tools.MailModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {
    float c;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        float cena = Float.parseFloat(request.getParameter("vc"));
        c=cena;
        System.out.println(cena);
        request.setAttribute("value", cena);
        String nextJSP = "/checkout.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context=getServletContext();
        float s = (Float)context.getAttribute("pro");
        System.out.println(s);
        request.setAttribute("value", c);
        request.setAttribute("rabat", s);
        String nextJSP = "/checkout.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }


}