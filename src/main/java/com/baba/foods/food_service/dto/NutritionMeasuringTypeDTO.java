package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
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
    @NotEmptyOrNull(message = "Type Must Not Be Empty")
    private String type;
    @NotEmptyOrNull(message = "MetricUnit Must Not Be Empty")
    private String metricUnit;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "NutritionServingSizes Must Not Be Empty")
    private Set<NutritionServingSize> nutritionServingSizes;

}
