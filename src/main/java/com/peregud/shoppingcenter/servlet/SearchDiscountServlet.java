package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/search-discount-shop")
public class SearchDiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int minimumDiscount = Integer.parseInt(request.getParameter(PARAM_MIN_DISCOUNT));
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesMinimumDiscount(minimumDiscount);
        request.setAttribute(ATTR_MIN_DISCOUNT, minimumDiscount);
        request.setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        request.getRequestDispatcher("view/display-discount-shops.jsp").forward(request, response);
    }
}
