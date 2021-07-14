package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.converter.ConverterImpl;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-shop")
public class UpdateShopServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Shop shop = ConverterImpl.convert(Shop.class, request);
        servletShopService.save(shop);
        response.sendRedirect(request.getContextPath() + "/list-shops");
    }
}
