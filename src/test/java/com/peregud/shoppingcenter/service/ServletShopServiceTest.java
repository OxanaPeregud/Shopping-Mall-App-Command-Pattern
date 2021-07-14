package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletShopServiceTest extends GenerateDataForH2 {
    ServletShopService servletShopService = new ServletShopService();

    @Test
    void getById_success() {
        assertEquals(shop2, servletShopService.getById(Shop.class, 2));
    }

    @Test
    void getById_fail() {
        assertNotEquals(shop2, servletShopService.getById(Shop.class, shop1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        ServletShopService servletShopService = mock(ServletShopService.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopService.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletShopService.getList(Shop.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        ServletShopService servletShopService = mock(ServletShopService.class);
        List<?> list = List.of(shop1, shop2);
        when(servletShopService.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(shop1), servletShopService.getList(Shop.class));
    }

    @Test
    void delete_success() {
        servletShopService.delete(Shop.class, shop1.getId());
        assertNull(servletShopService.getById(Shop.class, shop1.getId()));
    }

    @Test
    void delete_fail() {
        servletShopService.delete(Shop.class, shop1.getId());
        assertNotNull(servletShopService.getById(Shop.class, shop2.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void selectIdForSet_success() {
        ServletShopService servletShopService = mock(ServletShopService.class);
        when(servletShopService.selectIdForSet(shop1, shop1.getId())).thenReturn(any(List.class));
        assertEquals(any(List.class), servletShopService.selectIdForSet(shop1, shop1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void selectIdForSet_fail() {
        ServletShopService servletShopService = mock(ServletShopService.class);
        when(servletShopService.selectIdForSet(shop1, shop1.getId())).thenReturn(any(List.class));
        assertNotEquals(any(List.class), servletShopService.selectIdForSet(shop1, shop2.getId()));
    }
}
