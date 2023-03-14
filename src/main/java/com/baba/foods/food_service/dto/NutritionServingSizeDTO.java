package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import com.baba.foods.food_service.entity.NutritionMeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionServingSizeDTO {

    private Long id;
    private Integer value;
    private Date createdDate;
    private Date updatedDate;
    private Food food;
    private NutritionMeasuringType nutritionMeasuringType;

}
