package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.util.DiscountListenerUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DiscountListenerUtilTest {

    @Test
    void save_success() {
        assertEquals("50", DiscountListenerUtil.save("50").getDiscount());
    }

    @Test
    void save_fail() {
        assertNotEquals("30", DiscountListenerUtil.save("50"));
    }
}
