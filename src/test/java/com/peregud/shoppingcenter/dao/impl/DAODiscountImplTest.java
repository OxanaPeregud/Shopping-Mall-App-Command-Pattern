package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Discount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAODiscountImplTest extends GenerateDataForH2 {
    DAODiscountImpl daoDiscount = new DAODiscountImpl();

    @Test
    void getById_success() {
        assertEquals(discount2, daoDiscount.getById(Discount.class, discount2.getId()));
    }

    @Test
    void getById_fail() {
        assertNotEquals(discount1, daoDiscount.getById(Discount.class, discount2.getId()));
    }

    @Test
    void delete_success() {
        daoDiscount.delete(Discount.class, discount1.getId());
        assertNull(daoDiscount.getById(Discount.class, discount1.getId()));
    }

    @Test
    void delete_fail() {
        daoDiscount.delete(Discount.class, discount1.getId());
        assertNotNull(daoDiscount.getById(Discount.class, discount2.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_success() {
        DAODiscountImpl daoDiscount = mock(DAODiscountImpl.class);
        List<?> list = List.of(discount1, discount2);
        when(daoDiscount.getAll(any(Class.class))).thenReturn(list);
        assertEquals(list, daoDiscount.getAll(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_fail() {
        DAODiscountImpl daoDiscount = mock(DAODiscountImpl.class);
        List<?> list = List.of(discount1, discount2);
        when(daoDiscount.getAll(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(discount1), daoDiscount.getAll(Discount.class));
    }
}
