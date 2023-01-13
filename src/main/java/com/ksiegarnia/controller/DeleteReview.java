package com.ksiegarnia.controller;

import com.ksiegarnia.beans.Review;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.ReviewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * klasa odpowiadająca za obsługę usuwania istniejącej opinii
 */
@WebServlet(name = "DeleteReview", urlPatterns = {"/user/DeleteReview", "/admin/DeleteReview"})
@MultipartConfig
public class DeleteReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Review review = new ReviewModel().getReview(id);
        String path = request.getServletContext().getRealPath("");

        if (review == null) {
            request.getSession().setAttribute("message", "Nie znaleziono opinii");
            response.sendRedirect("../../failed.jsp");
        } else {
            User user = (User) request.getSession().getAttribute("LoginUser");
            request.setAttribute("review", review);
            new ReviewModel().deleteReview(id, path);
            if (user.getRola().equals("user")) {
                response.sendRedirect("ServletUserReview");
            } else if (user.getRola().equals("admin")){
                response.sendRedirect("ServletAdReview");
            }
        }
    }
}
