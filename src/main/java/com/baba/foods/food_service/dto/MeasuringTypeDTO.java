package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.ServingSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringTypeDTO {

    private Long id;
    @NotEmptyOrNull(message = "Type Must Not Be Empty")
    private String type;
    @NotEmptyOrNull(message = "MetricUnit Must Not Be Empty")
    private String metricUnit;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "ServingSize Must Not Be Empty")
    private Set<ServingSize> servingSize;

}
