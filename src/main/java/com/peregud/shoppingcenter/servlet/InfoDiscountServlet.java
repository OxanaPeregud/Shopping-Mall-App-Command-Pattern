package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info-discount")
public class InfoDiscountServlet extends HttpServlet {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = servletDiscountService.getById(id);
        request.setAttribute("discount", discount);
        request.getRequestDispatcher("view/discount-information.jsp").forward(request, response);
    }
}
