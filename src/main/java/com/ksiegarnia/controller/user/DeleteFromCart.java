package com.ksiegarnia.controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.model.CartModel;
/** servlet obsługujący usuwanie produktów z koszyka */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
    CartModel cartModel;

    /** funkcja usuwająca przedmioty z koszyka
     * @see com.ksiegarnia.model.CartModel#deleteCart
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cartModel = new CartModel();
        int id = Integer.parseInt(request.getParameter("id"));
        if(cartModel.deleteCart(id)){
            response.sendRedirect("/Ksiegarnia_war_exploded/ShoppingCart");
        }
    }
}
