package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.dto.AdditiveDTO;
import com.baba.foods.food_service.dto.FoodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/send")
    public ServiceResponseDTO addNewFood(
            @RequestBody FoodDTO foodDTO
    ) {
        log.info ("LOG :: FoodController addNewFood()");
        try {
            log.info ("LOG :: FoodController addNewFood() inside the try");
            return foodService.addNewFood(foodDTO);
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addNewFood() inside the catch");
            log.error(e.getMessage());
            ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setCode("500");
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
            return serviceResponseDTO;
        }
    }

    @GetMapping("/get/page/{pageNumber}/size/{size}")
    public ServiceResponseDTO getFoodDataWithPagination(
            @PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("size") Integer size
    ) {
        log.info ("LOG :: FoodController getFoodDataWithPagination()");
        try {
            log.info ("LOG :: FoodController getFoodDataWithPagination() inside the try");
            return foodService.getFoodDataWithPagination(pageNumber, size);
        } catch (Exception e) {
            log.warn ("LOG :: FoodController getFoodDataWithPagination() inside the catch");
            log.error(e.getMessage());
            ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setCode("500");
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
            return serviceResponseDTO;
        }
    }

    @PutMapping("id/{foodId}/add/additive")
    public ServiceResponseDTO addAdditiveForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody AdditiveDTO additiveDTO
    ) {
        log.info ("LOG :: FoodController addAdditiveForFood()");
        try {
            log.info ("LOG :: FoodController addAdditiveForFood() inside the try");
            return foodService.addAdditiveForFood(foodId, additiveDTO);
        } catch (Exception e) {
            log.info ("LOG :: FoodController addAdditiveForFood() inside the catch");
            ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setCode("500");
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
            return serviceResponseDTO;
        }
    }

}
