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

/** Servlet odpowiedzialny za usuwanie kodów rabatowych z poziomu panelu administratora */
@WebServlet(name = "DeletePromo", urlPatterns = {"/admin/DeletePromo"})
@MultipartConfig
public class DeletePromo extends HttpServlet {

    /** Usuwa wybrany kod rabatowy z bazy danych poprzez otrzymany parametr id danego kodu rabatowego.
     * @see com.ksiegarnia.model.PromoCodeModel#getCode
     * @see com.ksiegarnia.model.PromoCodeModel#deleteCode
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PromoCode code = new PromoCodeModel().getCode(id);
        if (code == null) {
            request.getSession().setAttribute("message", "Nie znaleziono kodu!");
            response.sendRedirect("../../failed.jsp");
        } else {
            new PromoCodeModel().deleteCode(id);
            response.sendRedirect("ServletAdPromo");
        }
    }
}
