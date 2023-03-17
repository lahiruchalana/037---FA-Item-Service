package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.response.AdditiveResponseDTO;
import com.baba.foods.food_service.entity.Additive;

public class AdditiveToResponseDTO {

    public static AdditiveResponseDTO getResponseDTO(Additive additive) {
        return AdditiveResponseDTO.builder()
                .listOfAdditives(additive.getListOfAdditives())
                .createdDate(additive.getCreatedDate())
                .updatedDate(additive.getUpdatedDate())
                .build();
    }
}
