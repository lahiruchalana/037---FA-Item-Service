package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.NutritionInformationDTO;
import com.baba.foods.food_service.entity.NutritionInformation;

public class NutritionInformationToResponseDTO {

    public static NutritionInformationDTO getResponseDTO(NutritionInformation nutritionInformation) {
        return NutritionInformationDTO.builder()
                .id(nutritionInformation.getId())
                .information(nutritionInformation.getInformation())
                .food(nutritionInformation.getFood())
                .createdDate(nutritionInformation.getCreatedDate())
                .updatedDate(nutritionInformation.getUpdatedDate())
                .build();
    }
}
