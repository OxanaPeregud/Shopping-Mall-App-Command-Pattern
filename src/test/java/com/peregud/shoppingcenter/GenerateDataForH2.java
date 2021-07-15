package com.peregud.shoppingcenter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.DiscountStatistics;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.DiscountServletService;
import com.peregud.shoppingcenter.service.ShopServletService;
import com.peregud.shoppingcenter.service.impl.DiscountServletServiceImpl;
import com.peregud.shoppingcenter.service.impl.DiscountStatisticsServletService;
import com.peregud.shoppingcenter.service.impl.DiscountStatisticsServletServiceImpl;
import com.peregud.shoppingcenter.service.impl.ShopServletServiceImpl;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class GenerateDataForH2 {
    protected Discount discount1;
    protected Discount discount2;
    protected Shop shop1;
    protected Shop shop2;
    protected DiscountStatistics discountStatistics;

    @BeforeEach
    public void generate() {
        ShopServletService shopServletService = new ShopServletServiceImpl();
        DiscountServletService discountServletService = new DiscountServletServiceImpl();
        DiscountStatisticsServletService discountStatisticsServletService = new DiscountStatisticsServletServiceImpl();
        shop1 = Shop.builder()
                .id(1)
                .name("name1")
                .description("description1")
                .location("location1")
                .build();
        shop2 = Shop.builder()
                .id(2)
                .name("name2")
                .description("description2")
                .location("location2")
                .build();
        discount1 = Discount.builder()
                .id(1)
                .discount(10)
                .discountStartDate(LocalDate.of(2021, 7, 2))
                .discountEndDate(LocalDate.of(2021, 8, 7))
                .build();
        discount2 = Discount.builder()
                .id(2)
                .discount(20)
                .discountStartDate(LocalDate.of(2021, 7, 2))
                .discountEndDate(LocalDate.of(2021, 8, 7))
                .build();
        discountStatistics = DiscountStatistics.builder()
                .id(1)
                .discount("10")
                .build();
        shopServletService.save(shop1);
        shopServletService.save(shop2);
        discountServletService.save(discount1);
        discountServletService.save(discount2);
        discountStatisticsServletService.save(discountStatistics);
    }
}
