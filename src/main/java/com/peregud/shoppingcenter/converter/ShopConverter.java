package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.converter.Converter;
import com.peregud.shoppingcenter.model.Shop;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class ShopConverter implements Converter<Shop> {

    @Override
    public Shop convert(HttpServletRequest request) {
        Shop.ShopBuilder builder = Shop.builder();
        Optional.ofNullable(request.getParameter(PARAM_ID))
                .map(Integer::parseInt)
                .ifPresent(builder::id);
        return builder
                .name(request.getParameter(PARAM_NAME))
                .description(request.getParameter(PARAM_DESCRIPTION))
                .location(request.getParameter(PARAM_LOCATION))
                .mobile(Long.parseLong(request.getParameter(PARAM_MOBILE)))
                .email(request.getParameter(PARAM_EMAIL))
                .build();
    }
}
