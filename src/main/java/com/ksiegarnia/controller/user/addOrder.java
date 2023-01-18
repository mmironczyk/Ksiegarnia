package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.*;
import com.ksiegarnia.model.*;
import jakarta.faces.context.FacesContext;
import jakarta.jms.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
/** servlet obsługujący dodanie zamówienia przez użytkownika */
@WebServlet("/addOrder")
public class addOrder extends HttpServlet {
    /** funkcja pozwalająca na dodanie zamówienia przez użytkownika
     * @see com.ksiegarnia.model.CartModel#getProductFromCart
     * @see com.ksiegarnia.model.ProductModel#zakup
     * @see com.ksiegarnia.model.OrderModel#allOrders 
     * @see com.ksiegarnia.model.PaymentModel#addPayment
     * @see com.ksiegarnia.model.PromoCodeModel#addUsage 
     * @see com.ksiegarnia.model.CartModel#deleteUserCart  
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        System.out.println("addOrder");
        User online = (User) session.getAttribute("LoginUser");
        User user = new User();
        user.setUserId(online.getUserId());
        ArrayList<ProductinCart> carts = new ArrayList<ProductinCart>();
        CartModel cartModel = new CartModel();
        carts = cartModel.getProductFromCart(online.getUserId());
        Order ord = new Order();
        String nr_zam = request.getParameter("nr_za");
        String kod = request.getParameter("kodrabatowy");
        for(int x=0;x<carts.size();x++)
        {
            ord.setId_klienta(online.getUserId());
            ord.setId_produktu(carts.get(x).getProductId());
            ord.setIlosc_produktu(carts.get(x).getAmount());
            ord.setNr_zamowienia(nr_zam);
            ord.setCena_sztuka((float) carts.get(x).getCost());
            new OrderModel().addOrder(ord);
            try {
                new ProductModel().zakup(carts.get(x).getAmount(),carts.get(x).getProductId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        float rabat = Float.parseFloat(request.getParameter("ra"));
        Payment payment = new Payment();
        payment.setId_klienta(online.getUserId());
        payment.setNr_zamowienia(nr_zam);
        payment.setKwota(Float.parseFloat(request.getParameter("kwota")));
        payment.setRabat(rabat);
        new PaymentModel().addPayment(payment);
        new PromoCodeModel().addUsage(kod);
        new CartModel().deleteUserCart(Integer.parseInt(request.getParameter("id")));
    }
}
