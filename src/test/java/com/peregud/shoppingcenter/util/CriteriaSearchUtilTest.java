package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.GenerateDataForH2;
import com.peregud.shoppingcenter.dto.DiscountDto;
import com.peregud.shoppingcenter.dto.DiscountStatisticsDto;
import com.peregud.shoppingcenter.dto.ShopDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CriteriaSearchUtilTest extends GenerateDataForH2 {

    @Test
    void shopKeywords() {
        ShopDto shopDto = ShopDto.builder()
                .id(1)
                .name("name1")
                .description("description1")
                .location("location1")
                .build();
        List<ShopDto> shopDtoList = List.of(shopDto);
        assertEquals(shopDtoList, CriteriaSearchUtil.shopKeywords("name1"));
    }

    @Test
    void minimumDiscount() {
        DiscountDto discountDto = DiscountDto.builder()
                .id(2)
                .discount(20)
                .discountStartDate(LocalDate.of(2021, 7, 2))
                .discountEndDate(LocalDate.of(2021, 8, 7))
                .build();
        List<DiscountDto> discountDtoList = List.of(discountDto);
        assertEquals(discountDtoList, CriteriaSearchUtil.minimumDiscount(15));
    }

    @Test
    void discountStatistics() {
        DiscountStatisticsDto discountStatisticsDto = DiscountStatisticsDto.builder()
                .discount("10")
                .count(1L)
                .build();
        List<DiscountStatisticsDto> discountStatisticsDtoList = List.of(discountStatisticsDto);
        assertEquals(discountStatisticsDtoList, CriteriaSearchUtil.discountStatistics());
    }
}
