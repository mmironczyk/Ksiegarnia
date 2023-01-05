package com.ksiegarnia.controller.admin;

import java.io.IOException;
import com.ksiegarnia.beans.PromoCode;
import com.ksiegarnia.model.PromoCodeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "AddCode", urlPatterns = {"/admin/AddCode"})
@MultipartConfig
public class AddCode extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kod = request.getParameter("kod");
        double rabat = Double.parseDouble(request.getParameter("wartosc"));
        int usage = 0;
        PromoCode code = new PromoCode();
        code.setCode(kod);
        code.setNumberofusage(usage);
        code.setValue(rabat);
        new PromoCodeModel().addCode(code);
        response.sendRedirect("adminDiscountCodes.jsp");
    }
}
