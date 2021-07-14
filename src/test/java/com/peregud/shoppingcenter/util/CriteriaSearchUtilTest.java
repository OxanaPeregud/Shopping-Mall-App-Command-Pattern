package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.dto.DiscountDto;
import com.peregud.shoppingcenter.dto.DiscountStatisticsDto;
import com.peregud.shoppingcenter.dto.ShopDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriteriaSearchUtilTest extends GenerateDataForH2 {

    @Test
    void shopKeywords_success() {
        assertEquals(new ShopDto(1, "name1", "description1", "location1"),
                CriteriaSearchUtil.shopKeywords("name").get(0));
    }

    @Test
    void shopKeywords_fail() {
        assertNotEquals(new ShopDto(1, "name1", "description1", "location1"),
                CriteriaSearchUtil.shopKeywords("shop"));
    }

    @Test
    void minimumDiscount_success() {
        assertEquals(new DiscountDto(1, 10,
                        LocalDate.of(2021, 7, 2),
                        LocalDate.of(2021, 8, 7)),
                CriteriaSearchUtil.minimumDiscount(5).get(0));
    }

    @Test
    void minimumDiscount_fail() {
        assertNotEquals(List.of(new DiscountDto(1, 10,
                        LocalDate.of(2021, 7, 2),
                        LocalDate.of(2021, 8, 7))),
                CriteriaSearchUtil.minimumDiscount(15));
    }

    @Test
    void discountStatistics_success() {
        assertEquals(List.of(new DiscountStatisticsDto("10", 1L)),
                CriteriaSearchUtil.discountStatistics());
    }

    @Test
    void discountStatistics_fail() {
        assertNotEquals(List.of(new DiscountStatisticsDto("10", 2L)),
                CriteriaSearchUtil.discountStatistics());
    }
}
