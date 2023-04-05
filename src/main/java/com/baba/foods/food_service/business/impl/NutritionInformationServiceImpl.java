package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.NutritionInformationService;
import com.baba.foods.food_service.dto.NutritionInformationDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.NutritionInformation;
import com.baba.foods.food_service.mapper.NutritionInformationToResponseDTO;
import com.baba.foods.food_service.repository.NutritionInformationRepository;
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
public class NutritionInformationServiceImpl implements NutritionInformationService {

    private final NutritionInformationRepository nutritionInformationRepository;

    @Override
    @Description("Insert NutritionInformation data or update NutritionInformation data when pass the NutritionInformationId")
    public ServiceResponseDTO addOrUpdateNutritionInformation(NutritionInformationDTO nutritionInformationDTO) {
        log.info ("LOG :: NutritionInformationServiceImpl addOrUpdateNutritionInformation()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: NutritionInformationServiceImpl addOrUpdateNutritionInformation() inside the try");
            NutritionInformation nutritionInformation = new NutritionInformation();
            nutritionInformation.setInformation(nutritionInformationDTO.getInformation());
            nutritionInformation.setFood(nutritionInformationDTO.getFood());
            nutritionInformation.setCreatedDate(nutritionInformationDTO.getCreatedDate());
            nutritionInformation.setUpdatedDate(nutritionInformationDTO.getUpdatedDate());
            if (nutritionInformationDTO.getId() != null) {
                nutritionInformation.setId(nutritionInformationDTO.getId());
            }
            NutritionInformation nutritionInformationSave = nutritionInformationRepository.save(nutritionInformation);
            serviceResponseDTO.setData(NutritionInformationToResponseDTO.getResponseDTO(nutritionInformationSave));
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: NutritionInformationServiceImpl addOrUpdateNutritionInformation() inside the catch");
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
