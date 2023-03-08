package com.example.item_service.business;

import com.example.item_service.dto.FoodDTO;
import com.example.item_service.dto.response.ServiceResponseDTO;

public interface FoodService {

    ServiceResponseDTO addNewFood(FoodDTO foodDTO);

    ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size);

}
