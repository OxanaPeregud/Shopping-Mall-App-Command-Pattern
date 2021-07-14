package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shop-discounts")
public class ShopDiscountsServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Shop shop = servletShopService.getById(id);
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesShopDiscounts(id);
        request.setAttribute("shop", shop);
        request.setAttribute("listDiscountShops", listDiscountShops);
        servletShopService.set(shop, id);
        request.getRequestDispatcher("view/display-shop-discounts.jsp").forward(request, response);
    }
}
