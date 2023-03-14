package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextureDTO {

    private Long id;
    private String listOfTexture;
    private Date createdDate;
    private Date updatedDate;
    private Food food;

}
