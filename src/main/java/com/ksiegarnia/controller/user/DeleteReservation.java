package com.ksiegarnia.controller.user;

import java.io.IOException;

import com.ksiegarnia.model.ReservationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/DeleteReservation")
public class DeleteReservation extends HttpServlet {
    ReservationModel res;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        res = new ReservationModel();
        int id = Integer.parseInt(request.getParameter("n"));
        if(res.deleteReservation(id)){
            response.sendRedirect("/Ksiegarnia_war_exploded/user/ShowReservation");
        }
    }
}
