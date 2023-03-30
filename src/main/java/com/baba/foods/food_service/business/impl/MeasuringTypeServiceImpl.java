package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.MeasuringTypeService;
import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.MeasuringTypeDTO;
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
public class MeasuringTypeServiceImpl implements MeasuringTypeService {

    @Override
    @Description("Insert MeasuringType data or update MeasuringType data when pass the MeasuringTypeId")
    public ServiceResponseDTO addOrUpdateMeasuringType(MeasuringTypeDTO measuringTypeDTO) {
        log.info ("LOG :: MeasuringTypeServiceImpl addOrUpdateMeasuringType()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: MeasuringTypeServiceImpl addOrUpdateMeasuringType() inside the try");
            // @TODO type logic here

            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: MeasuringTypeServiceImpl addOrUpdateMeasuringType() inside the catch");
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
