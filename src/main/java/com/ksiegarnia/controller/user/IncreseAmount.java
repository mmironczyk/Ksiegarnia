package com.ksiegarnia.controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.CartModel;

/** Servlet odpowedzialny za zwiększanie ilości produktów znajdujących się w koszyku. */
@WebServlet("/IncreseAmount")
public class IncreseAmount extends HttpServlet {
    /** Funkcja zwiększająca ilość produktów w koszyku.
     * @see com.ksiegarnia.model.CartModel#increaseQuantity */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartModel cartModel = new CartModel();
        int id = Integer.parseInt(request.getParameter("id"));
        boolean addCart = cartModel.increaseQuantity(id);
        User user = (User) request.getSession().getAttribute("LoginUser");
        response.getWriter().print(cartModel.getNubmberOfCartsForUser(user.getUserId()));
    }
}