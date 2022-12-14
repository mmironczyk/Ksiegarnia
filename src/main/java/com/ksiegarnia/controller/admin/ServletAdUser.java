package com.ksiegarnia.controller.admin;

import com.ksiegarnia.beans.User;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import com.ksiegarnia.model.UserDbModel;

@WebServlet("/admin/ServletAdUser")
public class ServletAdUser extends HttpServlet {

    List<User> allUsers = new ArrayList<User>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TEST");
        UserDbModel userModel = new UserDbModel();
        allUsers = userModel.getAllUsers();
        System.out.println(allUsers);
        request.setAttribute("allUsersAdmin", allUsers);
        String nextJSP = "/admin/adminPanelUsers.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

    }
}
