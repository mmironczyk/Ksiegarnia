package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.ProductinCart;
import com.ksiegarnia.beans.PromoCode;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.CartModel;
import com.ksiegarnia.model.PromoCodeModel;
import jakarta.faces.context.FacesContext;
import jakarta.jms.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;


@WebServlet("/Final")
public class Final extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User online = (User) session.getAttribute("LoginUser");
        User user = new User();
        user.setUserId(online.getUserId());
        ArrayList<ProductinCart> carts = new ArrayList<ProductinCart>();
        CartModel cartModel = new CartModel();
        carts = cartModel.getProductFromCart(online.getUserId());
        String nr_zam = givenUsingApache_whenGeneratingRandomNumericString_thenCorrect();
        String kod = request.getParameter("kod1");
        System.out.println(kod);
        user.setImie(request.getParameter("imie"));
        user.setNazwisko(request.getParameter("nazwisko"));
        user.setMiasto(request.getParameter("miejscowosc"));
        user.setAdres(request.getParameter("ulica"));
        user.setTelefon(request.getParameter("telefon"));
        user.setEmail(request.getParameter("email"));

        float kwota = Float.parseFloat(request.getParameter("kwota"));
        float rabat = Float.parseFloat(request.getParameter("rabat"));
        request.setAttribute("usr",user);
        request.setAttribute("kw",kwota);
        request.setAttribute("rb",rabat);
        request.setAttribute("nr_z",nr_zam);
        request.setAttribute("carts", carts);
        String nextJSP = "/final.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);


    }

    public String givenUsingApache_whenGeneratingRandomNumericString_thenCorrect() {
        String generatedString = RandomStringUtils.randomNumeric(12);
        System.out.println(generatedString);
        return generatedString;
    }


}
