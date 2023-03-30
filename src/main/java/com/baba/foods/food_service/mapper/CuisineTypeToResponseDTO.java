package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.entity.CuisineType;

public class CuisineTypeToResponseDTO {

    public static CuisineTypeDTO getResponseDTO(CuisineType cuisineType) {
        return CuisineTypeDTO.builder()
                .id(cuisineType.getId())
                .type(cuisineType.getType())
                .foods(cuisineType.getFoods())
                .createdDate(cuisineType.getCreatedDate())
                .updatedDate(cuisineType.getUpdatedDate())
                .build();
    }
}
