package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface FoodService {

    ServiceResponseDTO addOrUpdateFood(FoodDTO foodDTO);

    ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size);

    ServiceResponseDTO addOrUpdateAdditiveForFood(Long foodId, AdditiveDTO additiveDTO);

    ServiceResponseDTO addOrUpdateExpirationOrBestBeforeForFood(Long foodId, ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO);

    ServiceResponseDTO addOrUpdateFoodDescriptionForFood(Long foodId, FoodDescriptionDTO foodDescriptionDTO);

    ServiceResponseDTO addOrUpdatePortionForFood(Long foodId, PortionDTO portionDTO);

    ServiceResponseDTO addOrUpdatePreparationTimeForFood(Long foodId, PreparationTimeDTO preparationTimeDTO);

    ServiceResponseDTO addOrUpdateSmellTasteTextureForFood(Long foodId, SmellTasteTextureDTO smellTasteTextureDTO);

    ServiceResponseDTO addOrUpdateStorageInstructionForFood(Long foodId, StorageInstructionDTO storageInstructionDTO);

    ServiceResponseDTO updateFoodData(Long foodId, FoodDTO foodDTO);

}
