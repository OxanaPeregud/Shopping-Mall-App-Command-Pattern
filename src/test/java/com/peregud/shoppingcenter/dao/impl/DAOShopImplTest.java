package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAOShopImplTest extends GenerateDataForH2 {
    DAOShopImpl daoShop = new DAOShopImpl();

    @Test
    void getById_success() {
        assertEquals(shop1, daoShop.getById(Shop.class, shop1.getId()));
    }

    @Test
    void getById_fail() {
        assertNotEquals(shop1, daoShop.getById(Shop.class, shop2.getId()));
    }

    @Test
    void delete_success() {
        daoShop.delete(Shop.class, shop2.getId());
        assertNull(daoShop.getById(Shop.class, shop2.getId()));
    }

    @Test
    void delete_fail() {
        daoShop.delete(Shop.class, shop2.getId());
        assertNotNull(daoShop.getById(Shop.class, shop1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_success() {
        DAOShopImpl daoShop = mock(DAOShopImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(daoShop.getAll(any(Class.class))).thenReturn(list);
        assertEquals(list, daoShop.getAll(Shop.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_fail() {
        DAOShopImpl daoShop = mock(DAOShopImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(daoShop.getAll(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(shop1), daoShop.getAll(Shop.class));
    }
}
