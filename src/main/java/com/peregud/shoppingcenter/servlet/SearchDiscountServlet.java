package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-discount")
public class SearchDiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int minimumDiscount = Integer.parseInt(request.getParameter("minimumDiscount"));
        List<?> listDiscounts = CriteriaSearchUtil.minimumDiscount(minimumDiscount);
        request.setAttribute("minimumDiscount", minimumDiscount);
        request.setAttribute("listDiscounts", listDiscounts);
        request.getRequestDispatcher("view/display-discounts.jsp").forward(request, response);
    }
}
