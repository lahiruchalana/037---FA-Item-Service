package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.CuisineTypeService;
import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cuisine-type")
@RequiredArgsConstructor
@Slf4j
public class CuisineTypeController {

    private final CuisineTypeService cuisineTypeService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateCuisineType(
            @RequestBody CuisineTypeDTO cuisineTypeDTO
    ) {
        log.info ("LOG :: CuisineTypeController addOrUpdateCuisineType()");
        return cuisineTypeService.addOrUpdateCuisineType(cuisineTypeDTO);
    }
}
