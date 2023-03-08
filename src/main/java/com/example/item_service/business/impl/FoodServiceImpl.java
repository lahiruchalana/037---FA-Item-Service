package com.example.item_service.business.impl;

import com.example.item_service.dto.FoodDTO;
import com.example.item_service.dto.response.ServiceResponseDTO;
import com.example.item_service.business.FoodService;
import com.example.item_service.entity.Food;
import com.example.item_service.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public ServiceResponseDTO addNewFood(FoodDTO foodDTO) {
        log.info ("LOG :: FoodServiceImpl addNewFood()");
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDietaryRestriction(foodDTO.getDietaryRestriction());
        food.setCuisineType(foodDTO.getCuisineType());
        food.setCourse(foodDTO.getCourse());
        food.setCookingMethod(foodDTO.getCookingMethod());
        food.setThemes(foodDTO.getThemes());
        Food foodSave = foodRepository.save(food);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        serviceResponseDTO.setData(foodSave);
        serviceResponseDTO.setCode("200");
        serviceResponseDTO.setMessage("Success");
        serviceResponseDTO.setHttpStatus(HttpStatus.OK);
        serviceResponseDTO.setDescription("Successfully saved the data!!!");
        return null;
    }

    @Override
    public ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size) {
        log.info ("LOG :: FoodServiceImpl getFoodDataWithPagination()");
        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Food> foods = foodRepository.findAll(pageable);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        serviceResponseDTO.setData(foods);
        serviceResponseDTO.setCode("200");
        serviceResponseDTO.setMessage("Success");
        serviceResponseDTO.setHttpStatus(HttpStatus.OK);
        serviceResponseDTO.setDescription("Successfully received the data!!!");
        return serviceResponseDTO;
    }


}
