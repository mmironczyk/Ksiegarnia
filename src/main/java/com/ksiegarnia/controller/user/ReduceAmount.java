package com.ksiegarnia.controller.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.CartModel;
import java.io.IOException;

    @WebServlet("/ReduceAmount")
    public class ReduceAmount extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            CartModel cartModel = new CartModel();
            int id = Integer.parseInt(request.getParameter("id"));
            boolean addCart = cartModel.reduceQuantity(id);
            User user = (User) request.getSession().getAttribute("LoginUser");
            System.out.println("Odejmowanie");
            response.getWriter().print(cartModel.getNubmberOfCartsForUser(user.getUserId()));
        }
    }
