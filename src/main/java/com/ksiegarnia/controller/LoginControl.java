package com.ksiegarnia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ksiegarnia.beans.User;

/** Filtr ograniczający dostęp do fragmentów serwisu dla niezalogowanych użytkowników*/
@WebFilter(filterName = "Login",
        urlPatterns = {"/admin/adminPanelInvoices.jsp", "/admin/adminDiscountCodes.jsp","/admin/adminPanelOrders.jsp","/admin/adminPanelProducts.jsp","/admin/adminPanelOpinions.jsp","/admin/adminPanelPromoCodes.jsp","/admin/adminPanelUsers.jsp","/admin/productedit.jsp","/admin/addproduct.jsp" ,"/admin/ActivateUser","/admin/AddBook" ,"/admin/AddCode" ,"/admin/ClearBlock" ,
                "/admin/DeleteProduct" ,"/admin/DeletePromo" ,"/admin/DeleteUser" ,"/admin/ManageProduct","/admin/Orders" ,"/admin/ServletAdProduct" ,"/admin/ServletAdPromo" ,"/admin/ServletAdReview" ,
                "/admin/ServletAdUser", "/admin/DeleteReview", "/user/DeleteReview", "/user/AddCart", "/user/AddCartFromReservation", "/user/addOrder", "/user/ChangeAddres", "/user/ChangeEmail", "/user/ChangePassword", "/user/ChangePersonals",
                "/checkPromo", "/DeleteFromCart", "/user/DeleteReservation", "/Final", "/History", "/IncreseAmount", "/logout", "/ReduceAmount", "/user/ServletUserReview", "/Shipping", "/ShoppingCart", "/user/ShowReservation", "/user/userHistory", "/UsersCarts",
                "/user/DeleteReview", "/admin/DeleteReview", "/user/ManageReview", "/admin/ManageReview", "/history.jsp", "/shipping.jsp", "/zamowienia.jsp", "/user/userPanelInvoices.jsp", "/user/userPanelOpinions.jsp", "/user/userPanelOrders.jsp", "/user/userPanelProfile.jsp",
                "/user/userPanelReservation.jsp"})
public class LoginControl implements Filter {
    public LoginControl() {}
    /** Filtr sprawdza wywoływane adresy URL. Jeśli nieuprawniona osoba próbuje uzyskać dostęp, przekierowywana jest do strony logowania.*/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        User user = (User) hreq.getSession().getAttribute("LoginUser");
        if (user != null && user.getRola().equalsIgnoreCase("user") || user != null && user.getRola().equalsIgnoreCase("admin") )
        {
            chain.doFilter(request, response);
        } else {
            String redirectUrl = "/Ksiegarnia_war_exploded/login.jsp";
            if (hreq.getHeader("x-requested-with") != null
                    && hreq.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                HttpServletResponse hres = (HttpServletResponse) response;
                hres.setContentType("text/json; charset=UTF-8");
                PrintWriter out = hres.getWriter();
                String json = "{\"redirect\":\"" + redirectUrl + "\"}";
                out.write(json);
                out.flush();
                out.close();
            } else {
                ((HttpServletResponse) response).sendRedirect(redirectUrl);
            }
        }
    }
    @Override
    public void destroy() {}
    @Override
    public void init(FilterConfig filterConfig) {}
}
