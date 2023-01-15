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
/** servlet obsługujący podsumowanie zamówienia */
@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {
    float c;
    /** funkcja pobierajaca cene z koszyka i podstawia do podsumwoania */
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
    /** funkcja pobiera zwrócona wartość rabatu z servletu checkpromo i uzupełnia brakujące wartości  */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context=getServletContext();
        float s = (Float)context.getAttribute("pro");
        String st,ko;
        st=(String)context.getAttribute("msg");
        ko=(String)context.getAttribute("k");
        System.out.println(s);
        request.setAttribute("value", c);
        request.setAttribute("ko", ko);
        request.setAttribute("rabat", s);
        System.out.println(st);
        if(st!=""){request.setAttribute("ms",st);}
        String nextJSP = "/checkout.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }


}