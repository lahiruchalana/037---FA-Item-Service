package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * There is an issue with "${}", only works with @Value annotation not in others
 * @TODO - add "${end-points}"
 */

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    /**
     * response time for create -> 12-20ms
     * response time for update -> 15-25ms
     * When using serviceResponseDTO we can get lower response time
     * @TODO - add custom exceptions for receiving error messages
     */
    @PostMapping("/send")
    public ServiceResponseDTO addOrUpdateFood(
            @RequestBody FoodDTO foodDTO
    ) {
        log.info ("LOG :: FoodController addNewFood()");
        return foodService.addOrUpdateFood(foodDTO);
    }

    /**
     * ------ When using ServiceResponseDTO, SO USE ServiceResponseDTO-------
     * update response time -> 9ms -18ms
     * save response time -> ***
     *
     * ------ Before Using ServiceResponseDTO ------
     * update response time -> 20ms - 30ms
     * save response time -> 30ms -50ms
     */
    @PutMapping("id/{foodId}/addOrUpdate/smellTasteTexture")
    public ServiceResponseDTO addOrUpdateSmellTasteTextureForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody SmellTasteTextureDTO smellTasteTextureDTO
    ) {
        log.info ("LOG :: FoodController addSmellTasteTextureForFood()");
        return foodService.addOrUpdateSmellTasteTextureForFood(foodId, smellTasteTextureDTO);
    }

    @GetMapping("/get/page/{pageNumber}/size/{size}")
    public ServiceResponseDTO getFoodDataWithPagination(
            @PathVariable("pageNumber") Integer pageNumber,
            @PathVariable("size") Integer size
    ) {
        log.info ("LOG :: FoodController getFoodDataWithPagination()");
        return foodService.getFoodDataWithPagination(pageNumber, size);
    }

    /**
     * ------ When using ServiceResponseDTO, SO USE ServiceResponseDTO-------
     * response time for update -> 19-23ms
     * response time for create -> 25ms
     *
     * ------ Before Using ServiceResponseDTO ------
     * response time for update -> 24-30ms
     */
    @PutMapping("id/{foodId}/addOrUpdate/additive")
    public ServiceResponseDTO addOrUpdateAdditiveForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody AdditiveDTO additiveDTO
    ) {
        log.info ("LOG :: FoodController addAdditiveForFood()");
        return foodService.addOrUpdateAdditiveForFood(foodId, additiveDTO);
    }

    @PutMapping("id/{foodId}/addOrUpdate/expirationOrBestBefore")
    public ServiceResponseDTO addOrUpdateExpirationOrBestBeforeForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO
    ) {
        log.info ("LOG :: FoodController addExpirationOrBestBeforeForFood()");
        return foodService.addOrUpdateExpirationOrBestBeforeForFood(foodId, expirationOrBestBeforeDTO);
    }

    @PutMapping("id/{foodId}/addOrUpdate/foodDescription")
    public ServiceResponseDTO addOrUpdateFoodDescriptionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody FoodDescriptionDTO foodDescriptionDTO
    ) {
        log.info ("LOG :: FoodController addFoodDescriptionForFood()");
        return foodService.addOrUpdateFoodDescriptionForFood(foodId, foodDescriptionDTO);
    }

    @PutMapping("id/{foodId}/addOrUpdate/portion")
    public ServiceResponseDTO addOrUpdatePortionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody PortionDTO portionDTO
    ) {
        log.info ("LOG :: FoodController addPortionForFood()");
        return foodService.addOrUpdatePortionForFood(foodId, portionDTO);
    }

    @PutMapping("id/{foodId}/addOrUpdate/preparationTime")
    public ServiceResponseDTO addOrUpdatePreparationTimeForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody PreparationTimeDTO preparationTimeDTO
    ) {
        log.info ("LOG :: FoodController addPreparationTimeForFood()");
        return foodService.addOrUpdatePreparationTimeForFood(foodId, preparationTimeDTO);
    }

    @PutMapping("id/{foodId}/addOrUpdate/storageInstruction")
    public ServiceResponseDTO addOrUpdateStorageInstructionForFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody StorageInstructionDTO storageInstructionDTO
    ) {
        log.info ("LOG :: FoodController addStorageInstructionForFood()");
        return foodService.addOrUpdateStorageInstructionForFood(foodId, storageInstructionDTO);
    }

}
