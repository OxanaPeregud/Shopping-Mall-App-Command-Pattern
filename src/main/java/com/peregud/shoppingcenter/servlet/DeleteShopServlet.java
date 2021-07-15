package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/delete-shop")
public class DeleteShopServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        servletShopService.delete(id);
        response.sendRedirect(request.getContextPath() + "/list-shops");
    }
}
