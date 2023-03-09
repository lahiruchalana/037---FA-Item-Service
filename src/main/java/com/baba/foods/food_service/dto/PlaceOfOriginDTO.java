package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.OriginStatus;
import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOfOriginDTO {

    private Long id;
    private OriginStatus originStatus;
    private String country;
    private String provinceOrState;
    private String district;
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private String createdAt;
    private String updatedAt;
    private Food food;

}
