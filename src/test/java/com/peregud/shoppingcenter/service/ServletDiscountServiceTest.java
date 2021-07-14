package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Discount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletDiscountServiceTest extends GenerateDataForH2 {
    ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Test
    void getById_success() {
        assertEquals(10, servletDiscountService.getById(Discount.class, 1).getDiscount());
    }

    @Test
    void getById_fail() {
        assertNotEquals(50, servletDiscountService.getById(Discount.class, 1).getDiscount());
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        List<?> list = List.of(discount1);
        when(servletDiscountService.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletDiscountService.getList(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        List<?> list = List.of(discount1);
        when(servletDiscountService.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(Discount.builder()), servletDiscountService.getList(Discount.class));
    }

    @Test
    void delete_success() {
        servletDiscountService.delete(Discount.class, discount2.getId());
        assertNull(servletDiscountService.getById(Discount.class, discount2.getId()));
    }

    @Test
    void getSet_success() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        Set<Discount> set = Set.of(discount1);
        List<Integer> discountIdList = new ArrayList<>();
        when(servletDiscountService.getSet(any())).thenReturn(set);
        assertEquals(set, servletDiscountService.getSet(discountIdList));
    }

    @Test
    void getSet_fail() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        Set<Discount> set = Set.of(discount1);
        List<Integer> discountIdList = new ArrayList<>();
        when(servletDiscountService.getSet(any())).thenReturn(set);
        assertNotEquals(Set.of(Discount.builder()), servletDiscountService.getSet(discountIdList));
    }
}
