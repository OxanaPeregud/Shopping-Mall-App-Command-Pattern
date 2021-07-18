package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DisplayAllShopsCommand implements Command {
    private final ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<?> listShops = shopCommandService.getList(Shop.class);
        request.setAttribute(ATTR_LIST_SHOPS, listShops);
        request.getRequestDispatcher("view/display-shops.jsp").forward(request, response);
    }
}
