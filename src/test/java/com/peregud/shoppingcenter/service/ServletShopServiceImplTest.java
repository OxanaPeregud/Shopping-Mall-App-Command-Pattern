package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletShopServiceImplTest extends GenerateDataForH2 {
    ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Test
    void getById_success() {
        assertEquals(shop2, shopCommandService.getById(Shop.class, 2));
    }

    @Test
    void getById_fail() {
        assertNotEquals(shop2, shopCommandService.getById(Shop.class, shop1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        ShopCommandServiceImpl servletShopServiceImpl = mock(ShopCommandServiceImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletShopServiceImpl.getList(Shop.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        ShopCommandServiceImpl servletShopServiceImpl = mock(ShopCommandServiceImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(shop1), servletShopServiceImpl.getList(Shop.class));
    }

    @Test
    void delete_success() {
        shopCommandService.delete(Shop.class, shop1.getId());
        assertNull(shopCommandService.getById(Shop.class, shop1.getId()));
    }

    @Test
    void delete_fail() {
        shopCommandService.delete(Shop.class, shop1.getId());
        assertNotNull(shopCommandService.getById(Shop.class, shop2.getId()));
    }
}
