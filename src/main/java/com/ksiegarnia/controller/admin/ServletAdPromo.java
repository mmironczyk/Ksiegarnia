package com.ksiegarnia.controller.admin;

import com.ksiegarnia.beans.PromoCode;
import com.ksiegarnia.model.PromoCodeModel;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;


/** Servlet odpowiedzialny za przekazanie wszystkich kodów rabatowych z bazy danych do panelu administratora */
@WebServlet("/admin/ServletAdPromo")
public class ServletAdPromo extends HttpServlet {

    List<PromoCode> allCodes = new ArrayList<PromoCode>();

    /** Wyszukuje wszystkie kody rabatowe z bazy danych. Przekazuje dane do /admin/adminPanelPromoCodes.jsp.
     * @see com.ksiegarnia.model.PromoCodeModel#getAllCodes
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PromoCodeModel model = new PromoCodeModel();
        allCodes = model.getAllCodes();
        System.out.println(allCodes);
        request.setAttribute("allPromoAdmin", allCodes);
        String nextJSP = "/admin/adminPanelPromoCodes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }
}
