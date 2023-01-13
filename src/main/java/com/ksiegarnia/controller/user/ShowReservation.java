package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.ReservationRecord;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.ReservationModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/user/ShowReservation")
public class ShowReservation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("LoginUser");
        ArrayList<ReservationRecord> re = new ArrayList<>();
        ReservationModel model = new ReservationModel();
        re = model.allReservations(user.getUserId());
        request.setAttribute("reservation",re);
        String nextJSP = "/user/userPanelReservations.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
