package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.MeasuringTypeService;
import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.MeasuringType;
import com.baba.foods.food_service.mapper.MeasuringTypeToResponseDTO;
import com.baba.foods.food_service.repository.MeasuringTypeRepository;
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

    private final MeasuringTypeRepository measuringTypeRepository;

    @Override
    @Description("Insert MeasuringType data or update MeasuringType data when pass the MeasuringTypeId")
    public ServiceResponseDTO addOrUpdateMeasuringType(MeasuringTypeDTO measuringTypeDTO) {
        log.info ("LOG :: MeasuringTypeServiceImpl addOrUpdateMeasuringType()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: MeasuringTypeServiceImpl addOrUpdateMeasuringType() inside the try");
            MeasuringType measuringType = new MeasuringType();
            measuringType.setType(measuringTypeDTO.getType());
            measuringType.setServingSize(measuringTypeDTO.getServingSize());
            measuringType.setMetricUnit(measuringTypeDTO.getMetricUnit());
            measuringType.setCreatedDate(measuringTypeDTO.getCreatedDate());
            measuringType.setUpdatedDate(measuringTypeDTO.getUpdatedDate());
            if (measuringTypeDTO.getId() != null) {
                measuringType.setId(measuringTypeDTO.getId());
            }
            MeasuringType measuringTypeSave = measuringTypeRepository.save(measuringType);
            serviceResponseDTO.setData(MeasuringTypeToResponseDTO.getResponseDTO(measuringTypeSave));
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
