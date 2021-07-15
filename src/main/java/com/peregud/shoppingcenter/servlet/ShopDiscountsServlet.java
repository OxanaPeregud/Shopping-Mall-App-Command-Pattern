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

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/shop-discounts")
public class ShopDiscountsServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Shop shop = servletShopService.getById(id);
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesShopDiscounts(id);
        request.setAttribute(ATTR_SHOP, shop);
        request.setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        request.getRequestDispatcher("view/display-shop-discounts.jsp").forward(request, response);
    }
}
