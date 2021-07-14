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
public class DiscountDto {
    private Integer id;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
}
