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

/** Servlet odpowiedzialny za generowanie kodów rabatowych z poziomu panelu administratora */
@WebServlet(name = "AddCode", urlPatterns = {"/admin/AddCode"})
@MultipartConfig
public class AddCode extends HttpServlet {

    /** Funkcja odczytuje dane z formularza (kod i wartość procentową), po czym tworzy obiekt PromoCode zapisywany do bazy danych 
     * @see com.ksiegarnia.model.PromoCodeModel#addCode 
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kod = request.getParameter("kod");
        float rabat = Float.parseFloat(request.getParameter("wartosc"));
        int usage = 0;
        PromoCode code = new PromoCode();
        code.setCode(kod);
        code.setNumberofusage(usage);
        code.setValue(rabat);
        new PromoCodeModel().addCode(code);
        response.sendRedirect("adminDiscountCodes.jsp");
    }
}
