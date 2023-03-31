package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.Food;
import com.baba.foods.food_service.entity.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServingSizeDTO {

    private Long id;
    @NotEmptyOrNull(message = "Size Must Not Be Empty")
    private Double size;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Food food;
    @NotEmptyOrNull(message = "MeasuringType Must Not Be Empty")
    private MeasuringType measuringType;

}
