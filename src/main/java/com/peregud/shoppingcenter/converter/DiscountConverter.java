package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

public class DiscountConverter implements Converter<Discount> {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    public Discount convert(HttpServletRequest request) {
        int shopId = Integer.parseInt(request.getParameter("shopId"));
        Shop shop = servletShopService.getById(shopId);
        Discount.DiscountBuilder builder = Discount.builder();
        Optional.ofNullable(request.getParameter("id"))
                .map(Integer::parseInt)
                .ifPresent(builder::id);
        return builder
                .discount(Integer.parseInt(request.getParameter("discount")))
                .discountStartDate(LocalDate.parse(request.getParameter("discountStartDate")))
                .discountEndDate(LocalDate.parse(request.getParameter("discountEndDate")))
                .shop(shop)
                .build();
    }
}
