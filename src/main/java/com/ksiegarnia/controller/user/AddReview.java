package com.ksiegarnia.controller.user;

import com.ksiegarnia.beans.Product;
import com.ksiegarnia.beans.Review;
import com.ksiegarnia.beans.User;
import com.ksiegarnia.model.ProductModel;
import com.ksiegarnia.model.ReviewModel;
import com.ksiegarnia.tools.FileUpload;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddReview", urlPatterns = {"/AddReview"})
@MultipartConfig
public class AddReview extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("LoginUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int usrID = user.getUserId();
        System.out.println(usrID);
        int productID = Integer.parseInt(request.getParameter("pID"));
        System.out.println(productID);
        String reviewText = request.getParameter("reviewTextArea");
        System.out.println(reviewText);
        String link = request.getParameter("reviewYtLink");
        System.out.println(link);

        Review review = new Review();
        review.setUserId(usrID);
        review.setProductId(productID);
        review.setReviewText(reviewText);
        review.setLink(link);

        Part filePart = request.getPart("reviewImgInput");
        if (filePart.getSize() != 0) {
            String path = request.getServletContext().getRealPath("");
            try {
                String uploadPath = FileUpload.uploadImage(filePart, path);
                review.setReviewImage(uploadPath);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            review.setReviewImage("");
        }
        if (new ReviewModel().addReview(review)) {
            response.sendRedirect("Product?id="+productID);
        } else {
            response.sendRedirect("Product?id="+productID);
        }
    }
}

