package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display-discount-statistics")
public class DisplayDiscountStatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<?> listStatistics = CriteriaSearchUtil.discountStatistics();
        request.setAttribute("listStatistics", listStatistics);
        request.getRequestDispatcher("view/display-statistics.jsp").forward(request, response);
    }
}
