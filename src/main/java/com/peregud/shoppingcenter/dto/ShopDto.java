package com.peregud.shoppingcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private Integer id;
    private String name;
    private String description;
    private String location;
}
