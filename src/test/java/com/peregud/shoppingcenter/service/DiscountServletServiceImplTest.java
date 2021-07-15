package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.impl.DiscountServletServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiscountServletServiceImplTest extends GenerateDataForH2 {
    DiscountServletServiceImpl servletDiscountServiceImpl = new DiscountServletServiceImpl();

    @Test
    void getById_success() {
        assertEquals(10, servletDiscountServiceImpl.getById(Discount.class, 1).getDiscount());
    }

    @Test
    void getById_fail() {
        assertNotEquals(50, servletDiscountServiceImpl.getById(Discount.class, 1).getDiscount());
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        DiscountServletServiceImpl servletDiscountServiceImpl = mock(DiscountServletServiceImpl.class);
        List<?> list = List.of(discount1);
        when(servletDiscountServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletDiscountServiceImpl.getList(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        DiscountServletServiceImpl servletDiscountServiceImpl = mock(DiscountServletServiceImpl.class);
        List<?> list = List.of(discount1);
        when(servletDiscountServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(Discount.builder()), servletDiscountServiceImpl.getList(Discount.class));
    }

    @Test
    void delete_success() {
        servletDiscountServiceImpl.delete(Discount.class, discount2.getId());
        assertNull(servletDiscountServiceImpl.getById(Discount.class, discount2.getId()));
    }
}
