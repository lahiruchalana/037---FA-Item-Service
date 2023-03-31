package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
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
    @NotEmptyOrNull(message = "Value Must Not Be Empty")
    private Integer value;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Food food;
    @NotEmptyOrNull(message = "NutritionMeasuringType Must Not Be Empty")
    private NutritionMeasuringType nutritionMeasuringType;

}
