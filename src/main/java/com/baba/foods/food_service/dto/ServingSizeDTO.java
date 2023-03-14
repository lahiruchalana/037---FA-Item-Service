package com.baba.foods.food_service.dto;

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
    private Double size;
    private Date createdDate;
    private Date updatedDate;
    private Food food;
    private MeasuringType measuringType;

}
