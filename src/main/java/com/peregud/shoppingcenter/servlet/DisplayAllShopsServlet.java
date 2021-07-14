package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display-all-shops")
public class DisplayAllShopsServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<?> listShops = servletShopService.getList();
        request.setAttribute("listShops", listShops);
        request.getRequestDispatcher("view/display-shops.jsp").forward(request, response);
    }
}
