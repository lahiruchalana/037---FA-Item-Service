package com.example.item_service.controller;

import com.example.item_service.dto.FoodDTO;
import com.example.item_service.dto.response.ServiceResponseDTO;
import com.example.item_service.business.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/send")
    public ServiceResponseDTO addNewFood( @RequestBody FoodDTO foodDTO ) {
        log.info ("LOG :: FoodController addNewFood()");
        try {
            log.info ("LOG :: FoodController addNewFood() inside the try");
            return foodService.addNewFood(foodDTO);
        } catch (Exception e) {
            log.info ("LOG :: FoodController addNewFood() inside the catch");
            ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage("Fail");
            serviceResponseDTO.setCode("500");
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
            return serviceResponseDTO;
        }
    }

}
