package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.ThemeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface ThemeService {

    ServiceResponseDTO addOrUpdateTheme(ThemeDTO themeDTO);

}

