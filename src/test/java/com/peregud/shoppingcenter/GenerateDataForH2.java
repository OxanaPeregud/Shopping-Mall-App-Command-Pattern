package com.peregud.shoppingcenter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.DiscountStatistics;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import com.peregud.shoppingcenter.service.impl.DiscountStatisticsCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountStatisticsCommandServiceImpl;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
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
        ShopCommandService shopCommandService = new ShopCommandServiceImpl();
        DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();
        DiscountStatisticsCommandService discountStatisticsCommandService = new DiscountStatisticsCommandServiceImpl();
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
        shopCommandService.save(shop1);
        shopCommandService.save(shop2);
        discountCommandService.save(discount1);
        discountCommandService.save(discount2);
        discountStatisticsCommandService.save(discountStatistics);
    }
}
