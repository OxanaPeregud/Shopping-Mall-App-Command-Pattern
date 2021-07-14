package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConverterImpl {
    private static final Map<Class<?>, Converter<?>> CONVERTER_MAP;
    @Getter
    private static final Converter<Shop> SHOP_CONVERTER;
    private static final Converter<Discount> DISCOUNT_CONVERTER;

    static {
        SHOP_CONVERTER = new ShopConverter();
        DISCOUNT_CONVERTER = new DiscountConverter();

        CONVERTER_MAP = new HashMap<>();
        CONVERTER_MAP.put(Shop.class, SHOP_CONVERTER);
        CONVERTER_MAP.put(Discount.class, DISCOUNT_CONVERTER);
    }

    public static Converter<?> getConverter(Class<?> clazz) throws Exception {
        return Optional.ofNullable(CONVERTER_MAP.get(clazz)).orElseThrow(Exception::new);
    }

    @SuppressWarnings("unchecked")
    public static <T> T convert(Class<?> clazz, HttpServletRequest request) throws Exception {
        return (T) ConverterImpl.getConverter(clazz).convert(request);
    }
}
