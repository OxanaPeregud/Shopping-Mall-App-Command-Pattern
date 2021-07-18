package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConverterProvider {
    private static final Map<Class<?>, Converter<?>> CONVERTER_MAP;

    static {
        CONVERTER_MAP = new HashMap<>();
        CONVERTER_MAP.put(Shop.class, new ShopConverter());
        CONVERTER_MAP.put(Discount.class, new DiscountConverter());
    }

    public static Converter<?> getConverter(Class<?> clazz) throws Exception {
        return Optional.ofNullable(CONVERTER_MAP.get(clazz)).orElseThrow(Exception::new);
    }

    @SuppressWarnings("unchecked")
    public static <T> T convert(Class<?> clazz, HttpServletRequest request) throws Exception {
        return (T) ConverterProvider.getConverter(clazz).convert(request);
    }
}
