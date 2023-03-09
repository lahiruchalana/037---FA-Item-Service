package com.baba.foods.food_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppearanceDTO {

    private Long id;
    private String appearanceType;
    private String value;
    private String createdAt;
    private String updatedAt;
    private Long foodId;

}
