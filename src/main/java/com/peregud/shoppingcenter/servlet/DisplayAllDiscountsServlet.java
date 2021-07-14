package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display-all-discounts")
public class DisplayAllDiscountsServlet extends HttpServlet {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<?> listDiscounts = servletDiscountService.getList();
        request.setAttribute("listDiscounts", listDiscounts);
        request.getRequestDispatcher("view/display-discounts.jsp").forward(request, response);
    }
}
