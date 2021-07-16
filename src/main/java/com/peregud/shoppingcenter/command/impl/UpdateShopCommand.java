package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.util.CommandRedirectUtil;
import com.peregud.shoppingcenter.converter.ConverterProvider;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandType.*;

public class UpdateShopCommand implements Command {
    private final ShopServletService shopServletService = new ShopServletServiceImpl();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = ConverterProvider.convert(Shop.class, request);
        shopServletService.save(shop);
        response.sendRedirect(CommandRedirectUtil.page(LIST_SHOPS));
    }
}
