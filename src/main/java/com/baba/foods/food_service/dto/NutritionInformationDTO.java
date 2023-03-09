package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionInformationDTO {

    private Long id;
    private String information;
    private String createdAt;
    private String updatedAt;
    private Food food;

}
