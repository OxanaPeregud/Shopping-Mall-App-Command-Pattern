package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("view/logout.jsp").include(request, response);
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("controller?command=map");
        out.close();
    }
}