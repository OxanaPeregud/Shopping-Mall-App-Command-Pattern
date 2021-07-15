package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteListShopsCommand implements Command {
    private final ShopServletService shopServletService = new ShopServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        shopServletService.deleteList(Shop.class, request.getParameterValues(PARAM_DELETE_SHOP));
        List<?> listShops = shopServletService.getList(Shop.class);
        request.setAttribute(ATTR_LIST_SHOPS, listShops);
        request.getRequestDispatcher("view/shops-list.jsp").forward(request, response);
    }
}
