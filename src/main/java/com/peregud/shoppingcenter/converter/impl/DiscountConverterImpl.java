package com.peregud.shoppingcenter.converter.impl;

import com.peregud.shoppingcenter.converter.Converter;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DiscountConverterImpl implements Converter<Discount> {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    public Discount convert(HttpServletRequest request) {
        int shopId = Integer.parseInt(request.getParameter(PARAM_SHOP_ID));
        Shop shop = servletShopService.getById(shopId);
        Discount.DiscountBuilder builder = Discount.builder();
        Optional.ofNullable(request.getParameter(PARAM_ID))
                .map(Integer::parseInt)
                .ifPresent(builder::id);
        return builder
                .discount(Integer.parseInt(request.getParameter(PARAM_DISCOUNT)))
                .discountStartDate(LocalDate.parse(request.getParameter(PARAM_START_DATE)))
                .discountEndDate(LocalDate.parse(request.getParameter(PARAM_END_DATE)))
                .shop(shop)
                .build();
    }
}
