
package com.ksiegarnia.controller.user;
/** servlet obsługujący dodanie do koszyka rzeczy z rezerwacji */
import java.io.IOException;

import com.ksiegarnia.model.ReservationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.Cart;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.CartModel;

@WebServlet("/user/AddCartFromReservation")
public class AddCartFromReservation extends HttpServlet {
    @Override
    /** funkcja dodająca produkty znajdujące się w rezerwacji do koszyka
     * @see com.ksiegarnia.model.CartModel#addCart
     * @see com.ksiegarnia.model.ReservationModel#deleteReservation 
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartModel cartModel = new CartModel();
        int pID = Integer.parseInt(request.getParameter("id"));
        int rID = Integer.parseInt(request.getParameter("rezid"));
        int qaunty = Integer.parseInt(request.getParameter("amount"));
        User user = (User) request.getSession().getAttribute("LoginUser");
        Cart car = new Cart();
        car.setProductId(pID);
        car.setQuantity(qaunty);
        car.setUserId(user.getUserId());
        cartModel.addCart(car);
        new ReservationModel().deleteReservation(rID);
        response.sendRedirect("/Ksiegarnia_war_exploded/ShoppingCart");
    }
}
