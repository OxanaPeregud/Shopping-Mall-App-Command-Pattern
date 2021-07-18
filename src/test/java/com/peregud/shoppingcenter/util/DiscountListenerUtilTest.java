package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.model.DiscountStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountListenerUtilTest {

    @Test
    void save() {
        DiscountStatistics discountStatistics = DiscountStatistics.builder()
                .discount("20")
                .build();
        assertEquals(discountStatistics, DiscountListenerUtil.save("20"));
    }
}
