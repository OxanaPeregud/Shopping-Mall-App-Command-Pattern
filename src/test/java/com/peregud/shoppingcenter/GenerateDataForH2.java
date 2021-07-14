package com.peregud.shoppingcenter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.DiscountStatistics;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletService;
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
        ServletService<Shop> servletShopService = new ServletService<>();
        ServletService<Discount> servletDiscountService = new ServletService<>();
        ServletService<DiscountStatistics> servletDiscountStatisticsService = new ServletService<>();
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
        servletShopService.save(shop1);
        servletShopService.save(shop2);
        servletDiscountService.save(discount1);
        servletDiscountService.save(discount2);
        servletDiscountStatisticsService.save(discountStatistics);
    }
}
