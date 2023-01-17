package com.ksiegarnia.controller.user;

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
 * servlet pobierający wszystkie istniejące opinie dla danego IDUser
 * i przekazujący je do panelu użytkownika
 */
@WebServlet("/user/ServletUserReview")
public class ServletUserReview extends HttpServlet {

    List<Review> allReviews = new ArrayList<>();

    /** funkcja pozwalająca na pobranie opinii danego użytkownika
     * @see com.ksiegarnia.model.ReviewModel#getUserReviews
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewModel reviewModel = new ReviewModel();
        User user = (User) request.getSession().getAttribute("LoginUser");
        int usrID = user.getUserId();
        allReviews = reviewModel.getUserReviews(usrID);
        request.setAttribute("allReviewsUser", allReviews);
        String nextJSP = "/user/userPanelOpinions.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
