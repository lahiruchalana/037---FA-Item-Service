package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmellDTO {

    private Long id;
    private String smellName;
    private String createdAt;
    private String updatedAt;
    private Food food;

}
