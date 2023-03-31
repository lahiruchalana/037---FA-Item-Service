package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasteDTO {

    private Long id;
    @NotEmptyOrNull(message = "ListOfTaste Must Not Be Empty")
    private String listOfTaste;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Food food;

}
