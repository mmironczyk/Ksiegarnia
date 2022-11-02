package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import com.ksiegarnia.tools.MailModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        //-------------- get request paramater ------------------
        String login = request.getParameter("login");
        System.out.println("TEST"+login);
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        System.out.println("TEST"+email);
        String password = request.getParameter("password");
        System.out.println("TEST"+password);
        String adres = request.getParameter("adres");
        System.out.println("TEST"+adres);
        String telefon = request.getParameter("telefon");
        String kod = request.getParameter("kod");
        String miasto = request.getParameter("miasto");

        //-------------- create user object ------------------
       User user = new User();
        user.setLogin(login);
        user.setImie(imie);
        user.setNazwisko(nazwisko);
        user.setEmail(email);
        user.setHaslo(password);
        user.setAdres(adres);
        user.setTelefon(telefon);
        user.setKod(kod);
        user.setMiasto(miasto);
        System.out.println(user.getHaslo());
        if(new UserDbModel().signUp(user)){
            new MailModel(email,"","").sendActivationMail();
            getServletContext().getRequestDispatcher("/success2.jsp").forward(request, response);

        }else {
            request.setAttribute("message", "Cant't Signup <br/> Email or Cridt Card used before .. ");
            getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
        }
       
        
        
    }


        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
    }

