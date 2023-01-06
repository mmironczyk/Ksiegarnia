package com.ksiegarnia.controller.admin;
import com.ksiegarnia.beans.OrderRecord;
import com.ksiegarnia.model.OrderModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/admin/Orders")
public class Orders extends HttpServlet {

    List<OrderRecord> allOrders = new ArrayList<OrderRecord>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderModel model = new OrderModel();
        allOrders = model.allOrdersAdmin();
        request.setAttribute("allOrders", allOrders);
        String nextJSP = "/admin/adminPanelOrders.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }
}
