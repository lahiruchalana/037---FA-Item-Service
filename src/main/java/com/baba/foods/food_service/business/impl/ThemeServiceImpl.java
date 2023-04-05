package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.ThemeService;
import com.baba.foods.food_service.dto.ThemeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Theme;
import com.baba.foods.food_service.mapper.ThemeToResponseDTO;
import com.baba.foods.food_service.repository.ThemeRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baba.foods.food_service.utility.Utility.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Override
    @Description("Insert Theme data or update Theme data when pass the ThemeId")
    public ServiceResponseDTO addOrUpdateTheme(ThemeDTO themeDTO) {
        log.info ("LOG :: ThemeServiceImpl addOrUpdateTheme()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: ThemeServiceImpl addOrUpdateTheme() inside the try");
            Theme theme = new Theme();
            theme.setName(themeDTO.getName());
            theme.setFoods(themeDTO.getFoods());
            theme.setCreatedDate(themeDTO.getCreatedDate());
            theme.setUpdatedDate(themeDTO.getUpdatedDate());
            if (themeDTO.getId() != null) {
                theme.setId(themeDTO.getId());
            }
            Theme themeSave = themeRepository.save(theme);
            serviceResponseDTO.setData(ThemeToResponseDTO.getResponseDTO(themeSave));
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: ThemeServiceImpl addOrUpdateTheme() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }
}
