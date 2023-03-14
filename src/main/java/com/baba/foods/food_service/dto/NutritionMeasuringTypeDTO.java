package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.NutritionServingSize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionMeasuringTypeDTO {

    private Long id;
    private String type;
    private String metricUnit;
    private Date createdDate;
    private Date updatedDate;
    private Set<NutritionServingSize> nutritionServingSizes;

}
