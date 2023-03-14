package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Additive;
import com.baba.foods.food_service.entity.ExpirationOrBestBefore;
import com.baba.foods.food_service.entity.Food;
import com.baba.foods.food_service.repository.AdditiveRepository;
import com.baba.foods.food_service.repository.ExpirationOrBestBeforeRepository;
import com.baba.foods.food_service.repository.FoodRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final AdditiveRepository additiveRepository;
    private final ExpirationOrBestBeforeRepository expirationOrBestBeforeRepository;

    @Override
    public ServiceResponseDTO addNewFood(FoodDTO foodDTO) {
        log.info ("LOG :: FoodServiceImpl addNewFood()");
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDietaryRestriction(foodDTO.getDietaryRestriction());
        food.setCuisineType(foodDTO.getCuisineType());
        food.setCourse(foodDTO.getCourse());
        food.setCookingMethod(foodDTO.getCookingMethod());
        food.setThemes(foodDTO.getThemes());
        Food foodSave = foodRepository.save(food);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        serviceResponseDTO.setData(foodSave);
        serviceResponseDTO.setCode("200");
        serviceResponseDTO.setMessage("Success");
        serviceResponseDTO.setHttpStatus(HttpStatus.OK);
        serviceResponseDTO.setDescription("Successfully saved the data!!!");
        return null;
    }

    @Override
    public ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size) {
        log.info ("LOG :: FoodServiceImpl getFoodDataWithPagination()");
        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Food> foods = foodRepository.findAll(pageable);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        serviceResponseDTO.setData(foods);
        serviceResponseDTO.setCode("200");
        serviceResponseDTO.setMessage("Success");
        serviceResponseDTO.setHttpStatus(HttpStatus.OK);
        serviceResponseDTO.setDescription("Successfully received the data!!!");
        return serviceResponseDTO;
    }

    @Override
    @Description("Additive added for a food, " +
            "One food exist only one additive, " +
            "So if there is a additive available for a particular food then it will be updated with new additive")
    public ServiceResponseDTO addAdditiveForFood(Long foodId, AdditiveDTO additiveDTO) {
        log.info ("LOG :: FoodServiceImpl addAdditiveForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        if (foodOptional.isEmpty()) {
            log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId does not exist");
            serviceResponseDTO.setCode("404");
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
            serviceResponseDTO.setDescription("foodId does not exist");
        } else if (foodOptional.get().getAdditive() != null) {
            log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId exists && food has a additive");
            foodOptional.get().getAdditive().setListOfAdditives(additiveDTO.getListOfAdditives());
            foodOptional.get().getAdditive().setCreatedDate(additiveDTO.getCreatedDate());
            foodOptional.get().getAdditive().setUpdatedDate(additiveDTO.getUpdatedDate());
            serviceResponseDTO.setData(foodOptional.get().getAdditive());
            serviceResponseDTO.setMessage("Success");
            serviceResponseDTO.setCode("200");
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("additives added for food");
        } else {
            log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId exists && food has not a additive");
            Additive additive = new Additive();
            additive.setId(additiveDTO.getId());
            additive.setListOfAdditives(additiveDTO.getListOfAdditives());
            additive.setCreatedDate(additiveDTO.getCreatedDate());
            additive.setUpdatedDate(additiveDTO.getUpdatedDate());
            additive.setFood(foodOptional.get());
            Additive additiveSave = additiveRepository.save(additive);
            serviceResponseDTO.setData(additiveSave);
            serviceResponseDTO.setMessage("Success");
            serviceResponseDTO.setCode("200");
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("additives added for food");
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addExpirationOrBestBeforeForFood(Long foodId, ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO) {
        log.info ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        if (foodOptional.isEmpty()) {
            log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId does not exist");
            serviceResponseDTO.setCode("404");
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
            serviceResponseDTO.setDescription("foodId does not exist");
        } else if (foodOptional.get().getAdditive() != null) {
            log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId exists && food has a expirationOrBestBefore");
            foodOptional.get().getExpirationOrBestBefore().setTimeType(expirationOrBestBeforeDTO.getTimeType());
            foodOptional.get().getExpirationOrBestBefore().setTime(expirationOrBestBeforeDTO.getTime());
            foodOptional.get().getExpirationOrBestBefore().setNoteAboutExpiration(expirationOrBestBeforeDTO.getNoteAboutExpiration());
            foodOptional.get().getExpirationOrBestBefore().setCreatedDate(expirationOrBestBeforeDTO.getCreatedDate());
            foodOptional.get().getExpirationOrBestBefore().setUpdatedDate(expirationOrBestBeforeDTO.getUpdatedDate());
            serviceResponseDTO.setData(foodOptional.get().getAdditive());
            serviceResponseDTO.setMessage("Success");
            serviceResponseDTO.setCode("200");
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("additives added for food");
        } else {
            log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId exists && food has not a expirationOrBestBefore");
            ExpirationOrBestBefore expirationOrBestBefore = ExpirationOrBestBefore.builder()
                    .time(expirationOrBestBeforeDTO.getTime())
                    .timeType(expirationOrBestBeforeDTO.getTimeType())
                    .noteAboutExpiration(expirationOrBestBeforeDTO.getNoteAboutExpiration())
                    .food(expirationOrBestBeforeDTO.getFood())
                    .createdDate(expirationOrBestBeforeDTO.getCreatedDate())
                    .updatedDate(expirationOrBestBeforeDTO.getUpdatedDate())
                    .build();
            ExpirationOrBestBefore expirationOrBestBeforeSave = expirationOrBestBeforeRepository.save(expirationOrBestBefore);
            serviceResponseDTO.setData(expirationOrBestBeforeSave);
            serviceResponseDTO.setMessage("Success");
            serviceResponseDTO.setCode("200");
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("expirationOrBestBefore added for food");
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addFoodDescriptionForFood(Long foodId, FoodDescriptionDTO foodDescriptionDTO) {
        return null;
    }

    @Override
    public ServiceResponseDTO addPortionForFood(Long foodId, PortionDTO portionDTO) {
        return null;
    }

    @Override
    public ServiceResponseDTO addPreparationTimeForFood(Long foodId, PreparationTimeDTO preparationTimeDTO) {
        return null;
    }

    @Override
    public ServiceResponseDTO addSmellTasteTextureForFood(Long foodId, SmellDTO smellDTO, TasteDTO tasteDTO, TextureDTO textureDTO) {
        return null;
    }

    @Override
    public ServiceResponseDTO addStorageInstructionForFood(Long foodId, StorageInstructionDTO storageInstructionDTO) {
        return null;
    }

    @Override
    public ServiceResponseDTO updateFoodData(Long foodId, FoodDTO foodDTO) {
        return null;
    }


}
