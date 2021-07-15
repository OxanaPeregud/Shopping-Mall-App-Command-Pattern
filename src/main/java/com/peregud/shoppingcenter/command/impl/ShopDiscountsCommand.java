package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class ShopDiscountsCommand implements Command {
    private final ShopServletService shopServletService = new ShopServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Shop shop = shopServletService.getById(Shop.class, id);
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesShopDiscounts(id);
        request.setAttribute(ATTR_SHOP, shop);
        request.setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        request.getRequestDispatcher("view/display-shop-discounts.jsp").forward(request, response);
    }
}
