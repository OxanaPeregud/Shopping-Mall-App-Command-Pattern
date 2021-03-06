package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.util.CommandRedirectUtil;
import com.peregud.shoppingcenter.util.CheckAdminUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static com.peregud.shoppingcenter.command.CommandType.*;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter(PARAM_NAME);
        String password = request.getParameter(PARAM_PASSWORD);
        if (CheckAdminUtil.findAdmin(name, password)) {
            HttpSession session = request.getSession();
            session.setAttribute(ATTR_NAME, name);
            if (request.getParameter(PARAM_NAME).equals(ATTR_ADMIN)) {
                session.setAttribute(ATTR_ADMIN, name);
                response.sendRedirect(CommandRedirectUtil.page(LIST_SHOPS));
            } else if (request.getParameter(PARAM_NAME).equals(ATTR_MANAGER)) {
                session.setAttribute(ATTR_MANAGER, name);
                response.sendRedirect(CommandRedirectUtil.page(DISCOUNT_STATISTICS));
            }
        } else {
            out.print("<h3 text-align: center;>Incorrect username or password!</h3>");
            request.getRequestDispatcher("view/admin-login.jsp").include(request, response);
        }
        out.close();
    }
}
