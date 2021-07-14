package com.peregud.shoppingcenter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DiscountListenerServiceTest {
    DiscountListenerService discountListenerService = new DiscountListenerService();

    @Test
    void save_success() {
        assertEquals("50", discountListenerService.save("50").getDiscount());
    }

    @Test
    void save_fail() {
        assertNotEquals("30", discountListenerService.save("50"));
    }
}
