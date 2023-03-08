package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.FoodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface FoodService {

    ServiceResponseDTO addNewFood(FoodDTO foodDTO);

    ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size);

}
