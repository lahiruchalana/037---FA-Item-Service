package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.CookingMethodService;
import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.FoodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cooking-method")
@RequiredArgsConstructor
@Slf4j
public class CookingMethodController {

    private final CookingMethodService cookingMethodService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateCookingMethod(
            @RequestBody CookingMethodDTO cookingMethodDTO
    ) {
        log.info ("LOG :: CookingMethodController addOrUpdateCookingMethod()");
        return cookingMethodService.addOrUpdateCookingMethod(cookingMethodDTO);
    }

}
