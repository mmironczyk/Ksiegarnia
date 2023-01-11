package com.ksiegarnia.controller.user;

import java.io.IOException;
import java.sql.Date;

import com.ksiegarnia.beans.Reservation;
import com.ksiegarnia.model.ReservationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.User;

@WebServlet("/TEST")
public class TEST extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Reservation res = new Reservation();
            long millis=System.currentTimeMillis();
            Date data = new Date(millis);
            data.toLocalDate();
            System.out.println(data);
            res.setExpire_date(data);
            System.out.println(res.getExpire_date());
    }
}
