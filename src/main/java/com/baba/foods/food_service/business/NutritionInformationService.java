package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.NutritionInformationDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface NutritionInformationService {

    ServiceResponseDTO addOrUpdateNutritionInformation(NutritionInformationDTO nutritionInformationDTO);

}
