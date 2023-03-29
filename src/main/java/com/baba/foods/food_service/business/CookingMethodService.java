package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface CookingMethodService {

    ServiceResponseDTO addOrUpdateCookingMethod(CookingMethodDTO cookingMethodDTO);

}
