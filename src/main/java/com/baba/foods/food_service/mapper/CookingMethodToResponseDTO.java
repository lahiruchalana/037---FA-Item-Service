package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.entity.CookingMethod;

public class CookingMethodToResponseDTO {

    public static CookingMethodDTO getResponseDTO(CookingMethod cookingMethod) {
        return CookingMethodDTO.builder()
                .id(cookingMethod.getId())
                .method(cookingMethod.getMethod())
                .foods(cookingMethod.getFoods())
                .createdDate(cookingMethod.getCreatedDate())
                .updatedDate(cookingMethod.getUpdatedDate())
                .build();
    }
}
