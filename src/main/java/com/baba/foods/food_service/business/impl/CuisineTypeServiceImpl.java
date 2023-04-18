package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.CuisineTypeService;
import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.CuisineType;
import com.baba.foods.food_service.mapper.CuisineTypeToResponseDTO;
import com.baba.foods.food_service.repository.CuisineTypeRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baba.foods.food_service.utility.Utility.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CuisineTypeServiceImpl implements CuisineTypeService {

    private final CuisineTypeRepository cuisineTypeRepository;

    @Override
    @Description("Insert CuisineType data or update CuisineType data when pass the CuisineTypeId")
    @CacheEvict(value = "cuisineType", allEntries = true)
    public ServiceResponseDTO addOrUpdateCuisineType(CuisineTypeDTO cuisineTypeDTO) {
        log.info ("LOG :: CuisineTypeServiceImpl addOrUpdateCuisineType()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: CuisineTypeServiceImpl addOrUpdateCuisineType() inside the try");
            CuisineType cuisineType = new CuisineType();
            cuisineType.setType(cuisineTypeDTO.getType());
            cuisineType.setFoods(cuisineTypeDTO.getFoods());
            cuisineType.setCreatedDate(cuisineTypeDTO.getCreatedDate());
            cuisineType.setUpdatedDate(cuisineTypeDTO.getUpdatedDate());
            if (cuisineTypeDTO.getId() != null) {
                cuisineType.setId(cuisineTypeDTO.getId());
            }
            CuisineType cuisineTypeSave = cuisineTypeRepository.save(cuisineType);
            serviceResponseDTO.setData(CuisineTypeToResponseDTO.getResponseDTO(cuisineTypeSave));
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
