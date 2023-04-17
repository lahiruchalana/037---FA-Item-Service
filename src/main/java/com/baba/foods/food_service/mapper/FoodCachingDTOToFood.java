package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.caching.FoodCachingDTO;
import com.baba.foods.food_service.entity.Food;

public class FoodCachingDTOToFood {

    public static Food convertToFood(FoodCachingDTO foodCachingDTO) {
        Food food = new Food();
        food.setId(foodCachingDTO.getId());
        food.setName(foodCachingDTO.getName());
        food.setDietaryRestriction(foodCachingDTO.getDietaryRestriction());
        food.setCuisineType(foodCachingDTO.getCuisineType());
        food.setCourse(foodCachingDTO.getCourse());
        food.setCookingMethod(foodCachingDTO.getCookingMethod());
        food.setExpirationOrBestBefore(foodCachingDTO.getExpirationOrBestBefore());
        food.setFoodDescription(foodCachingDTO.getFoodDescription());
        food.setPreparationTime(foodCachingDTO.getPreparationTime());
        food.setAdditive(foodCachingDTO.getAdditive());
        food.setAvailability(foodCachingDTO.getAvailability());
        food.setPortion(foodCachingDTO.getPortion());
        food.setSmell(foodCachingDTO.getSmell());
        food.setTaste(foodCachingDTO.getTaste());
        food.setTexture(foodCachingDTO.getTexture());
        food.setCreatedDate(foodCachingDTO.getCreatedDate());
        food.setUpdatedDate(foodCachingDTO.getUpdatedDate());
        return food;
    }
}
