package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.converter.impl.ConverterImpl;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateShopCommand implements Command {
    private final ServletShopService servletShopService = new ServletShopService();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = ConverterImpl.convert(Shop.class, request);
        servletShopService.save(shop);
        response.sendRedirect("controller?command=list_shops");
    }
}
