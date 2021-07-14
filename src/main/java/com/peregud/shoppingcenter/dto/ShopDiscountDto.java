package com.peregud.shoppingcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDiscountDto {
    private String name;
    private String location;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
}
