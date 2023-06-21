package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.FoodService;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.baba.foods.food_service.utility.Utility.STATUS_2000;
import static com.baba.foods.food_service.utility.Utility.STATUS_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FoodController.class)
class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodService foodService;

    @Test
    void getFoodDataWithId() throws Exception {

        Food pizza = new Food(1L, "Pizza");

        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        serviceResponseDTO.setData(pizza);
        serviceResponseDTO.setCode(STATUS_2000);
        serviceResponseDTO.setMessage(STATUS_SUCCESS);
        serviceResponseDTO.setHttpStatus(HttpStatus.OK);
        serviceResponseDTO.setDescription("Successfully received the data!!!");

        when(foodService.getFoodDataWithId(1L)).thenReturn(serviceResponseDTO);

        mockMvc.perform(get("/api/food/get/id/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(pizza.getId()))
                .andExpect(jsonPath("$.data.name").value(pizza.getName()));

    }


}