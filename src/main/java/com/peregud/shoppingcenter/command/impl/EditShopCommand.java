package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class EditShopCommand implements Command {
    private final ShopServletService shopServletService = new ShopServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Shop shop = shopServletService.getById(Shop.class, id);
        request.setAttribute(ATTR_SHOP, shop);
        request.getRequestDispatcher("view/shop-form.jsp").forward(request, response);
    }
}
