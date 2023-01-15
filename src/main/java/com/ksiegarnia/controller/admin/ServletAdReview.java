package com.ksiegarnia.controller.admin;

import com.ksiegarnia.beans.Review;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.ReviewModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa pobierająca wszystkie istniejące opinie i przekazująca je do panelu admina
 */
@WebServlet("/admin/ServletAdReview")
public class ServletAdReview extends HttpServlet {

    List<Review> allReviews = new ArrayList<>();
    /** Wyszukuje wszystkie opinie z bazy danych i przekazuje je do panelu admina. Przekazuje dane do /admin/adminPanelOpinions.jsp.
     * @see com.ksiegarnia.model.ReviewModel#getAllReviews
     * */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewModel reviewModel = new ReviewModel();
        allReviews = reviewModel.getAllReviews() ;
        request.setAttribute("allReviewsUser", allReviews);
        String nextJSP = "/admin/adminPanelOpinions.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
