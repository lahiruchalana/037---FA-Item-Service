package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.controller.controllconfig.ResponseHandler;
import com.baba.foods.food_service.dto.AdditiveDTO;
import com.baba.foods.food_service.dto.FoodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/send")
    public ResponseEntity<Object> addNewFood(
            @RequestBody FoodDTO foodDTO
    ) {
        log.info ("LOG :: FoodController addNewFood()");
        try {
            log.info ("LOG :: FoodController addNewFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addNewFood(foodDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addNewFood() inside the catch");
            log.warn(String.valueOf(e));
            ServiceResponseDTO serviceResponseDTO = ServiceResponseDTO.builder()
                    .error(e)
                    .message("Fail")
                    .code("500")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .description(e.getMessage())
                    .build();
            return ResponseHandler.responseBuilder(serviceResponseDTO);
        }
    }

    @GetMapping("/get/page/{pageNumber}/size/{size}")
    public ResponseEntity<Object> getFoodDataWithPagination(
            @PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("size") Integer size
    ) {
        log.info ("LOG :: FoodController getFoodDataWithPagination()");
        try {
            log.info ("LOG :: FoodController getFoodDataWithPagination() inside the try");
            return ResponseHandler.responseBuilder(foodService.getFoodDataWithPagination(pageNumber, size));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController getFoodDataWithPagination() inside the catch");
            log.warn(String.valueOf(e));
            ServiceResponseDTO serviceResponseDTO = ServiceResponseDTO.builder()
                    .error(e)
                    .message("Fail")
                    .code("500")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .description(e.getMessage())
                    .build();
            return ResponseHandler.responseBuilder(serviceResponseDTO);
        }
    }

    @PutMapping("id/{foodId}/add/additive")
    public ResponseEntity<Object> addAdditiveForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody AdditiveDTO additiveDTO
    ) {
        log.info ("LOG :: FoodController addAdditiveForFood()");
        try {
            log.info ("LOG :: FoodController addAdditiveForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addAdditiveForFood(foodId, additiveDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addAdditiveForFood() inside the catch");
            log.warn(String.valueOf(e));
            ServiceResponseDTO serviceResponseDTO = ServiceResponseDTO.builder()
                    .error(e)
                    .message("Fail")
                    .code("500")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .description(e.getMessage())
                    .build();
            return ResponseHandler.responseBuilder(serviceResponseDTO);
        }
    }

}
