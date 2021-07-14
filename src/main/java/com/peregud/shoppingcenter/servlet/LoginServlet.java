package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final ServletAdminService servletAdminService = new ServletAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (servletAdminService.findAdmin(name, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            if (request.getParameter("name").equals("admin")) {
                session.setAttribute("admin", name);
                response.sendRedirect(request.getContextPath() + "/list-shops");
            } else if (request.getParameter("name").equals("manager")) {
                session.setAttribute("manager", name);
                response.sendRedirect(request.getContextPath() + "/display-all-shops");
            }
        } else {
            out.print("<h3 text-align: center;>Incorrect username or password!</h3>");
            request.getRequestDispatcher("view/admin-login.jsp").include(request, response);
        }
        out.close();
    }
}
