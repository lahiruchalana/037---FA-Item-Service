package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.MeasuringTypeService;
import com.baba.foods.food_service.dto.CuisineTypeDTO;
import com.baba.foods.food_service.dto.MeasuringTypeDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/measuring-type")
@RequiredArgsConstructor
@Slf4j
public class MeasuringTypeController {

    private final MeasuringTypeService measuringTypeService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateMeasuringType(
            @RequestBody MeasuringTypeDTO measuringTypeDTO
    ) {
        log.info ("LOG :: MeasuringTypeController addOrUpdateMeasuringType()");
        return measuringTypeService.addOrUpdateMeasuringType(measuringTypeDTO);
    }
}
