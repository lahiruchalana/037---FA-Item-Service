package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.response.FoodResponseDTO;
import com.baba.foods.food_service.entity.Food;

public class FoodToResponseDTO {

    public static FoodResponseDTO getResponseDTO(Food food) {
        return FoodResponseDTO.builder()
                .id(food.getId())
                .name(food.getName())
                .dietaryRestriction(food.getDietaryRestriction())
                .cuisineType(food.getCuisineType())
                .course(food.getCourse())
                .cookingMethod(food.getCookingMethod())
//                .themes(food.getThemes())
                .expirationOrBestBefore(food.getExpirationOrBestBefore())
                .foodDescription(food.getFoodDescription())
                .images(food.getImages())
                .quantities(food.getQuantities())
                .preparationTime(food.getPreparationTime())
                .availability(food.getAvailability())
                .portion(food.getPortion())
                .createdDate(food.getCreatedDate())
                .updatedDate(food.getUpdatedDate())
                .build();
    }
}
