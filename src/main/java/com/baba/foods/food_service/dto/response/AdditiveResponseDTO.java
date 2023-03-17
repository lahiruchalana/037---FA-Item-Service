package com.baba.foods.food_service.dto.response;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdditiveResponseDTO {    private Long id;

    private String listOfAdditives;
    private Date createdDate;
    private Date updatedDate;
}
