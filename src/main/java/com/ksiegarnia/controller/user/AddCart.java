
package com.ksiegarnia.controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.Cart;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.CartModel;

/** servlet obsługujący dodanie przedmiotu do koszyka. */
@WebServlet("/addCart")
public class AddCart extends HttpServlet {
    /** funkcja pozwalająca na dodanie przedmiotów do koszyka. Każdy produkt jest osobnym koszykiem.
     * @see com.ksiegarnia.model.CartModel#addCart
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartModel cartModel = new CartModel();
        int pID = Integer.parseInt(request.getParameter("id"));
        int qaunty = Integer.parseInt(request.getParameter("amount"));
        User user = (User) request.getSession().getAttribute("LoginUser");
        Cart car = new Cart();
        car.setProductId(pID);
        car.setQuantity(qaunty);
        car.setUserId(user.getUserId());
        cartModel.addCart(car);
    }
}
