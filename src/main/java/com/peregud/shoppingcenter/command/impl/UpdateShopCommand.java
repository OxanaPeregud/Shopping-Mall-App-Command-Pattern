package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.util.CommandRedirectUtil;
import com.peregud.shoppingcenter.converter.ConverterProvider;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandType.*;

public class UpdateShopCommand implements Command {
    private final ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = ConverterProvider.convert(Shop.class, request);
        shopCommandService.save(shop);
        response.sendRedirect(CommandRedirectUtil.page(LIST_SHOPS));
    }
}
