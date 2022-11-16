package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.UserDbModel;
import com.ksiegarnia.tools.MailModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();


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

        String kodakt = givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect();

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
        if(new UserDbModel().signUp(user,kodakt)){

            new MailModel(email,"","").sendActivationMail(kodakt);
            getServletContext().getRequestDispatcher("/success2.jsp").forward(request, response);

        }else {
            request.setAttribute("message", "Nie udało się zalogować");
            getServletContext().getRequestDispatcher("/failed.jsp").forward(request, response);
        }
    }
    public String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
        String generatedString = RandomStringUtils.randomAlphanumeric(20);
        System.out.println(generatedString);
        return generatedString;

    }
    }

