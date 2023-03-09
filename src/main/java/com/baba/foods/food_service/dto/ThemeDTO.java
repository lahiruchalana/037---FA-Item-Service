package com.baba.foods.food_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDTO {

    private Long id;
    private String name;
    private String createdAt;
    private String updatedAt;
    private Set<Long> foodIds;

}
