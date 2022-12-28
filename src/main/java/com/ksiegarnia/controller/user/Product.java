package com.ksiegarnia.controller.user;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

        import com.ksiegarnia.beans.Review;
        import com.ksiegarnia.model.ReviewModel;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import com.ksiegarnia.model.ProductModel;

@WebServlet(name = "Product", urlPatterns = {"/Product"})
public class Product extends HttpServlet {

    List<Review> allReviews = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        ProductModel productModel = new ProductModel();
        com.ksiegarnia.beans.Product product = productModel.getProduct(productID);
        if(product==null){
            response.sendRedirect("404.jsp");
        }else{
            ReviewModel reviewModel = new ReviewModel();
            allReviews = reviewModel.getProductReviews(productID);
            request.setAttribute("allReviews", allReviews);
            request.setAttribute("product", product);
            ArrayList<com.ksiegarnia.beans.Product> recommeendedItem = productModel.getRecommeendedItem(product.getCategory(), productID);
            request.setAttribute("recomed", recommeendedItem);
            request.getRequestDispatcher("/productPage.jsp").forward(request, response);
        }
    }
}
