package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.ServingSize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringTypeDTO {

    private Long id;
    private String type;
    private String metricUnit;
    private String createdAt;
    private String updatedAt;
    private Set<ServingSize> servingSize;

}
