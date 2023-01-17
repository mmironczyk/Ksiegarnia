package com.ksiegarnia.controller;

import com.ksiegarnia.beans.Review;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.ProductModel;
import com.ksiegarnia.model.ReviewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet odpowiadający za zarządzanie/przekierowanie do edycji wybranej opinii
 * (treść, link do filmu na YouTube)
 */
@WebServlet(name = "ManageReview", urlPatterns = {"/user/ManageReview", "/admin/ManageReview"})
@MultipartConfig
public class ManageReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Review review = new ReviewModel().getReview(id);

        if (review == null) {
            request.getSession().setAttribute("message", "Nie znaleziono opinii");
            response.sendRedirect("../../failed.jsp");
        } else {
            int productID = review.getProductId();
            com.ksiegarnia.beans.Product product = new ProductModel().getProduct(productID);
            String productTitle = "";
            if (product != null)
                productTitle = product.getTitle();
            request.setAttribute("review", review);
            request.setAttribute("productTitle", productTitle);
            request.getRequestDispatcher("../reviewEdit.jsp").forward(request, response);
        }
    }

    /**
     * funkcja pozwalająca na edycję wybranej opinii
     * @see com.ksiegarnia.model.ReviewModel#editReview
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reviewText = request.getParameter("reviewTextArea");
        String link = request.getParameter("reviewYtLink");
        int id = Integer.parseInt(request.getParameter("idr"));

        Review review = new Review();
        review.setReviewId(id);
        review.setReviewText(reviewText);
        review.setLink(link);
        new ReviewModel().editReview(review);
        User user = (User) request.getSession().getAttribute("LoginUser");
        if (user.getRola().equals("user")) {
            response.sendRedirect("ServletUserReview");
        } else if (user.getRola().equals("admin")){
            response.sendRedirect("ServletAdReview");
        }

    }
}
