package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.CuisineTypeService;
import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baba.foods.food_service.utility.Utility.*;
import static com.baba.foods.food_service.utility.Utility.STATUS_5000;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CuisineTypeServiceImpl implements CuisineTypeService {

    @Override
    @Description("Insert CuisineType data or update CuisineType data when pass the CuisineTypeId")
    public ServiceResponseDTO addOrUpdateCuisineType(CuisineTypeDTO cuisineTypeDTO) {
        log.info ("LOG :: CuisineTypeServiceImpl addOrUpdateCuisineType()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: CuisineTypeServiceImpl addOrUpdateCuisineType() inside the try");
            // @TODO type logic here

            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: CuisineTypeServiceImpl addOrUpdateCuisineType() inside the catch");
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
