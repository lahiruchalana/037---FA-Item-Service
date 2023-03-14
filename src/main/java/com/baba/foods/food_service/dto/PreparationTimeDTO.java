package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreparationTimeDTO {

    private Long id;
    private Integer time;
    private Date createdDate;
    private Date updatedDate;
    private Food food;

}
