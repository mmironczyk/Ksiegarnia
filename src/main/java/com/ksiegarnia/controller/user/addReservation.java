package com.ksiegarnia.controller.user;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.ksiegarnia.beans.Reservation;
import com.ksiegarnia.model.ReservationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.User;

@WebServlet("/addReservation")
public class addReservation extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ReservationModel reservationModel = new ReservationModel();
            Reservation res = new Reservation();
            long millis=System.currentTimeMillis();
            Date data = new Date(millis);
            data.toLocalDate();
            int pID = Integer.parseInt(request.getParameter("id"));
            int quanty = Integer.parseInt(request.getParameter("amount"));
            User user = (User) request.getSession().getAttribute("LoginUser");
            res.setProductId(pID);
            res.setUserId(user.getUserId());
            res.setQuantity(quanty);
            res.setExpire_date(data);
            try {
            reservationModel.zarezerwuj(res.getQuantity(),res.getProductId());
            } catch (SQLException e) {
            throw new RuntimeException(e);
            }
            reservationModel.addReservation(res);
            }
    }
