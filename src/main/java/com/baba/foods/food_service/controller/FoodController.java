package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.controller.controllconfig.ResponseHandler;
import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.FoodDescription;
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

    @PutMapping("id/{foodId}/addOrUpdate/additive")
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

    @PutMapping("id/{foodId}/addOrUpdate/expirationOrBestBefore")
    public ResponseEntity<Object> addExpirationOrBestBeforeForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO
    ) {
        log.info ("LOG :: FoodController addExpirationOrBestBeforeForFood()");
        try {
            log.info ("LOG :: FoodController addExpirationOrBestBeforeForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addExpirationOrBestBeforeForFood(foodId, expirationOrBestBeforeDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addExpirationOrBestBeforeForFood() inside the catch");
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

    @PutMapping("id/{foodId}/addOrUpdate/foodDescription")
    public ResponseEntity<Object> addFoodDescriptionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody FoodDescriptionDTO foodDescriptionDTO
    ) {
        log.info ("LOG :: FoodController addFoodDescriptionForFood()");
        try {
            log.info ("LOG :: FoodController addFoodDescriptionForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addFoodDescriptionForFood(foodId, foodDescriptionDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addFoodDescriptionForFood() inside the catch");
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

    @PutMapping("id/{foodId}/addOrUpdate/portion")
    public ResponseEntity<Object> addPortionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody PortionDTO portionDTO
    ) {
        log.info ("LOG :: FoodController addPortionForFood()");
        try {
            log.info ("LOG :: FoodController addPortionForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addPortionForFood(foodId, portionDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addPortionForFood() inside the catch");
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

    @PutMapping("id/{foodId}/addOrUpdate/preparationTime")
    public ResponseEntity<Object> addPreparationTimeForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody PreparationTimeDTO preparationTimeDTO
    ) {
        log.info ("LOG :: FoodController addPreparationTimeForFood()");
        try {
            log.info ("LOG :: FoodController addPreparationTimeForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addPreparationTimeForFood(foodId, preparationTimeDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addPreparationTimeForFood() inside the catch");
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

    @PutMapping("id/{foodId}/addOrUpdate/smellTasteTexture")
    public ResponseEntity<Object> addSmellTasteTextureForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody SmellTasteTextureDTO smellTasteTextureDTO
    ) {
        log.info ("LOG :: FoodController addSmellTasteTextureForFood()");
        try {
            log.info ("LOG :: FoodController addSmellTasteTextureForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addSmellTasteTextureForFood(foodId, smellTasteTextureDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addSmellTasteTextureForFood() inside the catch");
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

    @PutMapping("id/{foodId}/addOrUpdate/storageInstruction")
    public ResponseEntity<Object> addStorageInstructionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody StorageInstructionDTO storageInstructionDTO
    ) {
        log.info ("LOG :: FoodController addStorageInstructionForFood()");
        try {
            log.info ("LOG :: FoodController addStorageInstructionForFood() inside the try");
            return ResponseHandler.responseBuilder(foodService.addStorageInstructionForFood(foodId, storageInstructionDTO));
        } catch (Exception e) {
            log.warn ("LOG :: FoodController addStorageInstructionForFood() inside the catch");
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
