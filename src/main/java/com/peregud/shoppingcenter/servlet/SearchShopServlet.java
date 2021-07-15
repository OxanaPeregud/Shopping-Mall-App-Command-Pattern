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

@WebServlet("/search-shop")
public class SearchShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter(PARAM_SEARCH);
        List<?> listShops = CriteriaSearchUtil.shopKeywords(search);
        request.setAttribute(ATTR_LIST_SHOPS, listShops);
        request.getRequestDispatcher("view/display-shops.jsp").forward(request, response);
    }
}
