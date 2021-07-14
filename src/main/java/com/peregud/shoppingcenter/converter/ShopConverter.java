package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Shop;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ShopConverter implements Converter<Shop> {

    @Override
    public Shop convert(HttpServletRequest request) {
        Shop.ShopBuilder builder = Shop.builder();
        Optional.ofNullable(request.getParameter("id"))
                .map(Integer::parseInt)
                .ifPresent(builder::id);
        return builder
                .name(request.getParameter("name"))
                .description(request.getParameter("description"))
                .location(request.getParameter("location"))
                .mobile(Long.parseLong(request.getParameter("mobile")))
                .email(request.getParameter("email"))
                .build();
    }
}
