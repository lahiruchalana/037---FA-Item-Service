package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface FoodService {

    ServiceResponseDTO addNewFood(FoodDTO foodDTO);

    ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size);

    ServiceResponseDTO addAdditiveForFood(Long foodId, AdditiveDTO additiveDTO);

    ServiceResponseDTO addExpirationOrBestBeforeForFood(Long foodId, ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO);

    ServiceResponseDTO addFoodDescriptionForFood(Long foodId, FoodDescriptionDTO foodDescriptionDTO);

    ServiceResponseDTO addPortionForFood(Long foodId, PortionDTO portionDTO);

    ServiceResponseDTO addPreparationTimeForFood(Long foodId, PreparationTimeDTO preparationTimeDTO);

    ServiceResponseDTO addSmellTasteTextureForFood(Long foodId, SmellDTO smellDTO, TasteDTO tasteDTO, TextureDTO textureDTO);

    ServiceResponseDTO addStorageInstructionForFood(Long foodId, StorageInstructionDTO storageInstructionDTO);

    ServiceResponseDTO updateFoodData(Long foodId, FoodDTO foodDTO);

}
