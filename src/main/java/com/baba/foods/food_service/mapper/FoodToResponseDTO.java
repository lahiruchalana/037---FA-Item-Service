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
                .themes(food.getThemes())
                .allergens(food.getAllergens())
                .expirationOrBestBefore(food.getExpirationOrBestBefore())
                .cookingInstructions(food.getCookingInstructions())
                .foodDescription(food.getFoodDescription())
                .healthClaims(food.getHealthClaims())
                .images(food.getImages())
                .ingredients(food.getIngredients())
                .quantities(food.getQuantities())
                .nutritionInformationSet(food.getNutritionInformationSet())
                .packagingSet(food.getPackagingSet())
                .placeOfOriginSet(food.getPlaceOfOriginSet())
                .preparationTime(food.getPreparationTime())
                .additive(food.getAdditive())
                .appearances(food.getAppearances())
                .availability(food.getAvailability())
                .nutritionServingSizes(food.getNutritionServingSizes())
                .portion(food.getPortion())
                .smell(food.getSmell())
                .storageInstruction(food.getStorageInstruction())
                .taste(food.getTaste())
                .texture(food.getTexture())
                .createdDate(food.getCreatedDate())
                .updatedDate(food.getUpdatedDate())
                .build();
    }
}
