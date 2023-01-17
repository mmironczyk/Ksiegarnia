package com.ksiegarnia.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import com.ksiegarnia.model.CartModel;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.beans.ProductinCart;
/** Servlet koszyka. */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
/** Funkcja przekazuje listę produktów i umieszcza je w koszyku zalogowanego użytkownika.
 * @see com.ksiegarnia.model.CartModel#getProductFromCart */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ProductinCart> carts = new ArrayList<ProductinCart>();
        User usr = (User) request.getSession().getAttribute("LoginUser");
        int usrId = usr.getUserId();
        CartModel cartModel = new CartModel();
        carts = cartModel.getProductFromCart(usrId);
        request.setAttribute("carts", carts);
        String nextJSP = "/cart.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
