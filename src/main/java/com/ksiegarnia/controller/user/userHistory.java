package com.ksiegarnia.controller.user;
import com.ksiegarnia.beans.OrderRecord;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.OrderModel;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

/** Servlet zwracający historię zamówień użytkownika, zapisując do tabeli. */
@WebServlet("/user/userHistory")
public class userHistory extends HttpServlet {

    List<OrderRecord> allOrders = new ArrayList<OrderRecord>();
    /** Funkcja tworząca historię zamówień zalogowanego użytkownika, zapisując do tabeli produkty wybrane w procesie zamawiania.
     * @see com.ksiegarnia.model.OrderModel#allOrders */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User online = (User) session.getAttribute("LoginUser");
        User user = new User();
        OrderModel model = new OrderModel();
        allOrders = model.allOrders(online.getUserId());
        request.setAttribute("allOrders", allOrders);
        String nextJSP = "/user/userPanelOrders.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
