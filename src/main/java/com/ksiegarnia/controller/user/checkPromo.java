package com.ksiegarnia.controller.user;

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

/** servlet obsługujący sprawdzenie kodu promocyjnego */
@WebServlet("/checkPromo")
public class checkPromo extends HttpServlet {

    /** funkcja sprawdzająca czy podany kod rabatowy jest poprawny
     *  @see com.ksiegarnia.model.PromoCodeModel#getCodeFromString
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PromoCodeModel model = new PromoCodeModel();
        String s = request.getParameter("kod");
        PromoCode code = model.getCodeFromString(s);
        if(code!=null){
            ServletContext context=getServletContext();
            context.setAttribute("pro",code.getValue());
            context.setAttribute("k",s);
            context.setAttribute("msg","true");
            response.sendRedirect("/Ksiegarnia_war_exploded/checkout");
        }
        else
        {
            float r = 0;
            ServletContext context=getServletContext();
            context.setAttribute("pro",r);
            context.setAttribute("k",s);
            context.setAttribute("msg","false");
            response.sendRedirect("/Ksiegarnia_war_exploded/checkout");
        }
    }
}
