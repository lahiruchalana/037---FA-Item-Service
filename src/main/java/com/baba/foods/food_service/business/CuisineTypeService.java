package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface CuisineTypeService {

    ServiceResponseDTO addOrUpdateCuisineType(CuisineTypeDTO cuisineTypeDTO);

}
