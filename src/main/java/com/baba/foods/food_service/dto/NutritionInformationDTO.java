package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionInformationDTO {

    private Long id;
    private String information;
    private Date createdDate;
    private Date updatedDate;
    private Food food;

}
