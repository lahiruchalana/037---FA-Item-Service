package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface MeasuringTypeService {

    ServiceResponseDTO addOrUpdateMeasuringType(MeasuringTypeDTO measuringTypeDTO);

}
