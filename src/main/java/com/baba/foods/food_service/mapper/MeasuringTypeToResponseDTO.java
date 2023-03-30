package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.entity.MeasuringType;

public class MeasuringTypeToResponseDTO {

    public static MeasuringTypeDTO getResponseDTO(MeasuringType measuringType) {
        return MeasuringTypeDTO.builder()
                .id(measuringType.getId())
                .type(measuringType.getType())
                .metricUnit(measuringType.getMetricUnit())
                .servingSize(measuringType.getServingSize())
                .createdDate(measuringType.getCreatedDate())
                .updatedDate(measuringType.getUpdatedDate())
                .build();
    }
}
