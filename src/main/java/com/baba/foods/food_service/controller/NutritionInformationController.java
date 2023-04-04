package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.NutritionInformationService;
import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.dto.NutritionInformationDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/nutrition-information")
@RequiredArgsConstructor
@Slf4j
public class NutritionInformationController {

    private final NutritionInformationService nutritionInformationService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateNutritionInformation(
            @RequestBody NutritionInformationDTO nutritionInformationDTO
    ) {
        log.info ("LOG :: NutritionInformationController addOrUpdateNutritionInformation()");
        return nutritionInformationService.addOrUpdateNutritionInformation(nutritionInformationDTO);
    }
}
