package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteShopCommand implements Command {
    private final ShopServletService shopServletService = new ShopServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        shopServletService.delete(Shop.class, id);
        response.sendRedirect("controller?command=list_shops");
    }
}
