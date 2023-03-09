package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookingMethodDTO {

    private Long id;
    private String method;
    private String createdAt;
    private String updatedAt;
    private Set<Food> foods;

}
