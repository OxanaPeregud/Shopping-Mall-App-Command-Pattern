package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiscountCommandServiceImplTest extends GenerateDataForH2 {
    DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();

    @Test
    void getById_success() {
        assertEquals(10, discountCommandService.getById(Discount.class, 1).getDiscount());
    }

    @Test
    void getById_fail() {
        assertNotEquals(50, discountCommandService.getById(Discount.class, 1).getDiscount());
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        DiscountCommandServiceImpl servletDiscountServiceImpl = mock(DiscountCommandServiceImpl.class);
        List<?> list = List.of(discount1);
        when(servletDiscountServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletDiscountServiceImpl.getList(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        DiscountCommandServiceImpl servletDiscountServiceImpl = mock(DiscountCommandServiceImpl.class);
        List<?> list = List.of(discount1);
        when(servletDiscountServiceImpl.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(Discount.builder()), servletDiscountServiceImpl.getList(Discount.class));
    }

    @Test
    void delete_success() {
        discountCommandService.delete(Discount.class, discount2.getId());
        assertNull(discountCommandService.getById(Discount.class, discount2.getId()));
    }
}
