package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.CookingMethodService;
import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.CookingMethod;
import com.baba.foods.food_service.mapper.CookingMethodToResponseDTO;
import com.baba.foods.food_service.repository.CookingMethodRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baba.foods.food_service.utility.Utility.*;
import static com.baba.foods.food_service.utility.Utility.STATUS_5000;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CookingMethodServiceImpl implements CookingMethodService {

    private CookingMethodRepository cookingMethodRepository;

    @Override
    @Description("Insert CookingMethod data or update CookingMethod data when pass the CookingMethodId")
    @CacheEvict(value = "cookingMethod", allEntries = true )
    public ServiceResponseDTO addOrUpdateCookingMethod(CookingMethodDTO cookingMethodDTO) {
        log.info ("LOG :: CookingMethodServiceImpl addOrUpdateFood()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: CookingMethodServiceImpl addOrUpdateFood() inside the try");
            CookingMethod cookingMethod = new CookingMethod();
            cookingMethod.setMethod(cookingMethodDTO.getMethod());
            cookingMethod.setFoods(cookingMethodDTO.getFoods());
            cookingMethod.setCreatedDate(cookingMethodDTO.getCreatedDate());
            cookingMethod.setUpdatedDate(cookingMethodDTO.getUpdatedDate());
            if (cookingMethodDTO.getId() != null) {
                cookingMethod.setId(cookingMethodDTO.getId());
            }
            CookingMethod cookingMethodSave = cookingMethodRepository.save(cookingMethod);
            serviceResponseDTO.setData(CookingMethodToResponseDTO.getResponseDTO(cookingMethodSave));
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: CookingMethodServiceImpl addOrUpdateFood() inside the catch");
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
