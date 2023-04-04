package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.dto.*;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.dto.response.SmellTasteTextureResponseDTO;
import com.baba.foods.food_service.entity.*;
import com.baba.foods.food_service.mapper.AdditiveToResponseDTO;
import com.baba.foods.food_service.mapper.FoodToResponseDTO;
import com.baba.foods.food_service.repository.*;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.baba.foods.food_service.utility.Utility.*;
import static java.lang.Thread.sleep;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final AdditiveRepository additiveRepository;
    private final ExpirationOrBestBeforeRepository expirationOrBestBeforeRepository;
    private final FoodDescriptionRepository foodDescriptionRepository;
    private final PortionRepository portionRepository;
    private final PreparationTimeRepository preparationTimeRepository;
    private final SmellRepository smellRepository;
    private final TasteRepository tasteRepository;
    private final TextureRepository textureRepository;
    private final StorageInstructionRepository storageInstructionRepository;

    /**
     * // TODO: 3/17/2023
     *  set for update food data
     *  and there is a 500 internal server error for when save food data
     *  change method names to addOrUpdateNewFood ---
     *  --- in service and controller level
     */
    @Override
    @Description("Insert food data")
    public ServiceResponseDTO addNewFood(FoodDTO foodDTO) {
        log.info ("LOG :: FoodServiceImpl addNewFood()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addNewFood() inside the try");
            Food food = new Food();
            food.setName(foodDTO.getName());
            food.setDietaryRestriction(foodDTO.getDietaryRestriction());
            food.setCuisineType(foodDTO.getCuisineType());
            food.setCourse(foodDTO.getCourse());
            food.setCookingMethod(foodDTO.getCookingMethod());
            food.setThemes(foodDTO.getThemes());
            if (foodDTO.getId() != null) {
                food.setId(foodDTO.getId());
            }
            Food foodSave = foodRepository.save(food);
            serviceResponseDTO.setData(FoodToResponseDTO.getResponseDTO(foodSave));
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addNewFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    @Description("Get food data with pagination")
    @Cacheable(value = "foodPaginationCache")
    public ServiceResponseDTO getFoodDataWithPagination(Integer pageNumber, Integer size) {
        log.info ("LOG :: FoodServiceImpl getFoodDataWithPagination()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl getFoodDataWithPagination() inside the try");
            Pageable pageable = PageRequest.of(pageNumber, size);
            Page<Food> foods = foodRepository.findAll(pageable);
            serviceResponseDTO.setData(foods);
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully received the data!!!");
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl getFoodDataWithPagination() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
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
        try {
            log.info ("LOG :: FoodServiceImpl addAdditiveForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getAdditive() != null) {
                log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId exists && food has a additive - to add additives");
                foodOptional.get().getAdditive().setListOfAdditives(additiveDTO.getListOfAdditives());
                foodOptional.get().getAdditive().setCreatedDate(additiveDTO.getCreatedDate());
                foodOptional.get().getAdditive().setUpdatedDate(additiveDTO.getUpdatedDate());
                serviceResponseDTO.setData(AdditiveToResponseDTO.getResponseDTO(foodOptional.get().getAdditive()));
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("additives updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() foodId exists && food has not a additive - to add additives");
                Additive additive = new Additive();
                additive.setId(additiveDTO.getId());
                additive.setListOfAdditives(additiveDTO.getListOfAdditives());
                additive.setCreatedDate(additiveDTO.getCreatedDate());
                additive.setUpdatedDate(additiveDTO.getUpdatedDate());
                additive.setFood(foodOptional.get());
                Additive additiveSave = additiveRepository.save(additive);
                serviceResponseDTO.setData(AdditiveToResponseDTO.getResponseDTO(additiveSave));
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("additives added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addAdditiveForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addExpirationOrBestBeforeForFood(Long foodId, ExpirationOrBestBeforeDTO expirationOrBestBeforeDTO) {
        log.info ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getExpirationOrBestBefore() != null) {
                log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId exists && food has a expirationOrBestBefore - to add expirationOrBestBefore");
                foodOptional.get().getExpirationOrBestBefore().setTimeType(expirationOrBestBeforeDTO.getTimeType());
                foodOptional.get().getExpirationOrBestBefore().setTime(expirationOrBestBeforeDTO.getTime());
                foodOptional.get().getExpirationOrBestBefore().setNoteAboutExpiration(expirationOrBestBeforeDTO.getNoteAboutExpiration());
                foodOptional.get().getExpirationOrBestBefore().setCreatedDate(expirationOrBestBeforeDTO.getCreatedDate());
                foodOptional.get().getExpirationOrBestBefore().setUpdatedDate(expirationOrBestBeforeDTO.getUpdatedDate());
                serviceResponseDTO.setData(foodOptional.get().getExpirationOrBestBefore());
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("expirationOrBestBefore updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() foodId exists && food has not a expirationOrBestBefore - to add expirationOrBestBefore");
                ExpirationOrBestBefore expirationOrBestBefore = ExpirationOrBestBefore.builder()
                        .time(expirationOrBestBeforeDTO.getTime())
                        .timeType(expirationOrBestBeforeDTO.getTimeType())
                        .noteAboutExpiration(expirationOrBestBeforeDTO.getNoteAboutExpiration())
                        .food(foodOptional.get())
                        .createdDate(expirationOrBestBeforeDTO.getCreatedDate())
                        .updatedDate(expirationOrBestBeforeDTO.getUpdatedDate())
                        .build();
                ExpirationOrBestBefore expirationOrBestBeforeSave = expirationOrBestBeforeRepository.save(expirationOrBestBefore);
                serviceResponseDTO.setData(expirationOrBestBeforeSave);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("expirationOrBestBefore added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addExpirationOrBestBeforeForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addFoodDescriptionForFood(Long foodId, FoodDescriptionDTO foodDescriptionDTO) {
        log.info ("LOG :: FoodServiceImpl addFoodDescriptionForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addFoodDescriptionForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addFoodDescriptionForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getFoodDescription() != null) {
                log.warn ("LOG :: FoodServiceImpl addFoodDescriptionForFood() foodId exists && food has a foodDescription - to add foodDescription");
                foodOptional.get().getFoodDescription().setDescription(foodDescriptionDTO.getDescription());
                foodOptional.get().getFoodDescription().setMainDescription(foodDescriptionDTO.getMainDescription());
                foodOptional.get().getFoodDescription().setCreatedDate(foodDescriptionDTO.getCreatedDate());
                foodOptional.get().getFoodDescription().setUpdatedDate(foodDescriptionDTO.getUpdatedDate());
                serviceResponseDTO.setData(foodOptional.get().getFoodDescription());
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("foodDescription updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addFoodDescriptionForFood() foodId exists && food has not a foodDescription - to add foodDescription");
                FoodDescription foodDescription = FoodDescription.builder()
                        .description(foodDescriptionDTO.getDescription())
                        .mainDescription(foodDescriptionDTO.getMainDescription())
                        .food(foodOptional.get())
                        .createdDate(foodDescriptionDTO.getCreatedDate())
                        .updatedDate(foodDescriptionDTO.getUpdatedDate())
                        .build();
                FoodDescription foodDescriptionSave = foodDescriptionRepository.save(foodDescription);
                serviceResponseDTO.setData(foodDescriptionSave);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("foodDescription added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addFoodDescriptionForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addPortionForFood(Long foodId, PortionDTO portionDTO) {
        log.info ("LOG :: FoodServiceImpl addPortionForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addPortionForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addPortionForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getPortion() != null) {
                log.warn ("LOG :: FoodServiceImpl addPortionForFood() foodId exists && food has a portion - to add portion");
                foodOptional.get().getPortion().setNumberOfPortion(portionDTO.getNumberOfPortion());
                foodOptional.get().getPortion().setQuantity(portionDTO.getQuantity());
                foodOptional.get().getPortion().setCreatedDate(portionDTO.getCreatedDate());
                foodOptional.get().getPortion().setUpdatedDate(portionDTO.getUpdatedDate());
                serviceResponseDTO.setData(foodOptional.get().getPortion());
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("portion updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addPortionForFood() foodId exists && food has not a portion - to add portion");
                Portion portion = Portion.builder()
                        .numberOfPortion(portionDTO.getNumberOfPortion())
                        .quantity(portionDTO.getQuantity())
                        .food(foodOptional.get())
                        .createdDate(portionDTO.getCreatedDate())
                        .updatedDate(portionDTO.getUpdatedDate())
                        .build();
                Portion portionSave = portionRepository.save(portion);
                serviceResponseDTO.setData(portionSave);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("portion added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addPortionForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addPreparationTimeForFood(Long foodId, PreparationTimeDTO preparationTimeDTO) {
        log.info ("LOG :: FoodServiceImpl addPreparationTimeForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addPreparationTimeForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addPreparationTimeForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getPreparationTime() != null) {
                log.warn ("LOG :: FoodServiceImpl addPreparationTimeForFood() foodId exists && food has a preparationTime - to update preparationTime");
                foodOptional.get().getPreparationTime().setTime(preparationTimeDTO.getTime());
                foodOptional.get().getPreparationTime().setCreatedDate(preparationTimeDTO.getCreatedDate());
                foodOptional.get().getPreparationTime().setUpdatedDate(preparationTimeDTO.getUpdatedDate());
                serviceResponseDTO.setData(foodOptional.get().getPreparationTime());
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("preparationTime updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addPreparationTimeForFood() foodId exists && food has not a preparationTime - to add preparationTime");
                PreparationTime preparationTime = PreparationTime.builder()
                        .time(preparationTimeDTO.getTime())
                        .food(foodOptional.get())
                        .createdDate(preparationTimeDTO.getCreatedDate())
                        .updatedDate(preparationTimeDTO.getUpdatedDate())
                        .build();
                PreparationTime preparationTimeSave = preparationTimeRepository.save(preparationTime);
                serviceResponseDTO.setData(preparationTimeSave);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("preparationTime added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addPreparationTimeForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    @Description("Smell, Taste and Texture are added or updated to a food, " +
            "adding smell, taste and texture is happening at same time" +
            "also updating smell, taste and texture is happening at same time")
    @Async
    public ServiceResponseDTO addSmellTasteTextureForFood(Long foodId, SmellTasteTextureDTO smellTasteTextureDTO) {
        log.info ("LOG :: FoodServiceImpl addSmellTasteTextureForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addSmellTasteTextureForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addSmellTasteTextureForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getSmell() != null || foodOptional.get().getTaste() != null || foodOptional.get().getTexture() != null) {
                log.warn ("LOG :: FoodServiceImpl addSmellTasteTextureForFood() foodId exists && food has a SmellTasteTexture - to update SmellTasteTexture");
                foodOptional.get().getSmell().setSmellName(smellTasteTextureDTO.getSmell().getSmellName());
                foodOptional.get().getTaste().setListOfTaste(smellTasteTextureDTO.getTaste().getListOfTaste());
                foodOptional.get().getTexture().setListOfTexture(smellTasteTextureDTO.getTexture().getListOfTexture());
                SmellTasteTextureResponseDTO smellTasteTextureResponseDTO = SmellTasteTextureResponseDTO.builder()
                        .smell(foodOptional.get().getSmell())
                        .taste(foodOptional.get().getTaste())
                        .texture(foodOptional.get().getTexture())
                        .build();
                serviceResponseDTO.setData(smellTasteTextureResponseDTO);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("SmellTasteTexture updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addSmellTasteTextureForFood() foodId exists && food has not a SmellTasteTexture - to add SmellTasteTexture");
                Smell smell = Smell.builder()
                        .smellName(smellTasteTextureDTO.getSmell().getSmellName())
                        .food(foodOptional.get())
                        .createdDate(smellTasteTextureDTO.getSmell().getCreatedDate())
                        .updatedDate(smellTasteTextureDTO.getSmell().getUpdatedDate())
                        .build();
                Smell smellSave = smellRepository.save(smell);
                Taste taste = Taste.builder()
                        .listOfTaste(smellTasteTextureDTO.getTaste().getListOfTaste())
                        .food(foodOptional.get())
                        .createdDate(smellTasteTextureDTO.getTaste().getCreatedDate())
                        .updatedDate(smellTasteTextureDTO.getTaste().getUpdatedDate())
                        .build();
                Taste tasteSave = tasteRepository.save(taste);
                Texture texture = Texture.builder()
                        .listOfTexture(smellTasteTextureDTO.getTexture().getListOfTexture())
                        .food(foodOptional.get())
                        .createdDate(smellTasteTextureDTO.getTexture().getCreatedDate())
                        .updatedDate(smellTasteTextureDTO.getTexture().getUpdatedDate())
                        .build();
                Texture textureSave = textureRepository.save(texture);
                SmellTasteTextureResponseDTO smellTasteTextureResponseDTO = SmellTasteTextureResponseDTO.builder()
                        .smell(smellSave)
                        .taste(tasteSave)
                        .texture(textureSave)
                        .build();
                serviceResponseDTO.setData(smellTasteTextureResponseDTO);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("SmellTasteTexture added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addSmellTasteTextureForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO addStorageInstructionForFood(Long foodId, StorageInstructionDTO storageInstructionDTO) {
        log.info ("LOG :: FoodServiceImpl addStorageInstructionForFood()");
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        System.out.println(foodOptional);
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: FoodServiceImpl addStorageInstructionForFood() inside the try");
            if (foodOptional.isEmpty()) {
                log.warn ("LOG :: FoodServiceImpl addStorageInstructionForFood() foodId does not exist");
                serviceResponseDTO.setCode(STATUS_4040);
                serviceResponseDTO.setMessage(STATUS_FAIL);
                serviceResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);
                serviceResponseDTO.setDescription("foodId does not exist");
            } else if (foodOptional.get().getStorageInstructions() != null) {
                log.warn ("LOG :: FoodServiceImpl addStorageInstructionForFood() foodId exists && food has a storageInstruction - to update storageInstruction");
                foodOptional.get().getStorageInstructions().setInstruction(storageInstructionDTO.getInstruction());
                foodOptional.get().getStorageInstructions().setCreatedDate(storageInstructionDTO.getCreatedDate());
                foodOptional.get().getStorageInstructions().setUpdatedDate(storageInstructionDTO.getUpdatedDate());
                serviceResponseDTO.setData(foodOptional.get().getStorageInstructions());
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("storageInstruction updated with new data for the particular food");
            } else {
                log.warn ("LOG :: FoodServiceImpl addStorageInstructionForFood() foodId exists && food has not a storageInstruction - to add storageInstruction");
                StorageInstruction storageInstruction = StorageInstruction.builder()
                        .instruction(storageInstructionDTO.getInstruction())
                        .food(foodOptional.get())
                        .createdDate(storageInstructionDTO.getCreatedDate())
                        .updatedDate(storageInstructionDTO.getUpdatedDate())
                        .build();
                StorageInstruction storageInstructionSave = storageInstructionRepository.save(storageInstruction);
                serviceResponseDTO.setData(storageInstructionSave);
                serviceResponseDTO.setMessage(STATUS_SUCCESS);
                serviceResponseDTO.setCode(STATUS_2000);
                serviceResponseDTO.setHttpStatus(HttpStatus.OK);
                serviceResponseDTO.setDescription("storageInstruction added for food");
            }
        } catch (Exception e) {
            log.warn ("LOG :: FoodServiceImpl addStorageInstructionForFood() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO updateFoodData(Long foodId, FoodDTO foodDTO) {
        return null;
    }


}
