package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.ThemeDTO;
import com.baba.foods.food_service.entity.Theme;

public class ThemeToResponseDTO {

    public static ThemeDTO getResponseDTO(Theme theme) {
        return ThemeDTO.builder()
                .id(theme.getId())
                .name(theme.getName())
                .foods(theme.getFoods())
                .createdDate(theme.getCreatedDate())
                .updatedDate(theme.getUpdatedDate())
                .build();
    }
}
