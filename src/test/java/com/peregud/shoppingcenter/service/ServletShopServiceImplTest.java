package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletShopServiceImplTest extends GenerateDataForH2 {
    ShopServletServiceImpl servletShopServiceImpl = new ShopServletServiceImpl();

    @Test
    void getById_success() {
        assertEquals(shop2, servletShopServiceImpl.getById(Shop.class, 2));
    }

    @Test
    void getById_fail() {
        assertNotEquals(shop2, servletShopServiceImpl.getById(Shop.class, shop1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        ShopServletServiceImpl servletShopServiceImpl = mock(ShopServletServiceImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletShopServiceImpl.getList(Shop.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        ShopServletServiceImpl servletShopServiceImpl = mock(ShopServletServiceImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(shop1), servletShopServiceImpl.getList(Shop.class));
    }

    @Test
    void delete_success() {
        servletShopServiceImpl.delete(Shop.class, shop1.getId());
        assertNull(servletShopServiceImpl.getById(Shop.class, shop1.getId()));
    }

    @Test
    void delete_fail() {
        servletShopServiceImpl.delete(Shop.class, shop1.getId());
        assertNotNull(servletShopServiceImpl.getById(Shop.class, shop2.getId()));
    }
}
