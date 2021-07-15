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

import static com.peregud.shoppingcenter.command.CommandConstant.*;

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
        String name = request.getParameter(PARAM_NAME);
        String password = request.getParameter(PARAM_PASSWORD);
        if (servletAdminService.findAdmin(name, password)) {
            HttpSession session = request.getSession();
            session.setAttribute(ATTR_NAME, name);
            if (request.getParameter(PARAM_NAME).equals(ATTR_ADMIN)) {
                session.setAttribute(ATTR_ADMIN, name);
                response.sendRedirect(request.getContextPath() + "/list-shops");
            } else if (request.getParameter(PARAM_NAME).equals(ATTR_MANAGER)) {
                session.setAttribute(ATTR_MANAGER, name);
                response.sendRedirect(request.getContextPath() + "/display-discount-statistics");
            }
        } else {
            out.print("<h3 text-align: center;>Incorrect username or password!</h3>");
            request.getRequestDispatcher("view/admin-login.jsp").include(request, response);
        }
        out.close();
    }
}
