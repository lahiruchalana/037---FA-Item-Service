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
public class CourseDTO {

    private Long id;
    @NotEmptyOrNull(message = "Name Must Not Be Empty")
    private String name;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Set<Food> foods;

}
