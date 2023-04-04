package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.ThemeService;
import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.dto.ThemeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/theme")
@RequiredArgsConstructor
@Slf4j
public class ThemeController {

    private final ThemeService themeService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateTheme(
            @RequestBody ThemeDTO themeDTO
    ) {
        log.info ("LOG :: ThemeController addOrUpdateTheme()");
        return themeService.addOrUpdateTheme(themeDTO);
    }
}
