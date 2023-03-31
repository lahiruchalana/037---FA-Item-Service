package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CookingMethodDTO {

    private Long id;
    @NotEmptyOrNull(message = "Method Must Not Be Empty")
    private String method;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Foods Must Not Be Empty")
    private Set<Food> foods;

}
