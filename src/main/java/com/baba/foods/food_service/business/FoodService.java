package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.FoodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface FoodService {

    ServiceResponseDTO addNewFood(FoodDTO foodDTO);

    ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size);

    ServiceResponseDTO addAdditiveForFood(Long foodId, );

    ServiceResponseDTO addExpirationOrBestBeforeForFood(Long foodId, );

    ServiceResponseDTO addFoodDescriptionForFood(Long foodId, );

    ServiceResponseDTO addPortionForFood(Long foodId, );

    ServiceResponseDTO addPreparationTimeForFood(Long foodId, );

    ServiceResponseDTO addSmellTasteTextureForFood(Long foodId, );

    ServiceResponseDTO addStorageInstructionForFood(Long foodId, );

    ServiceResponseDTO updateFoodData(Long foodId, FoodDTO foodDTO);

}
