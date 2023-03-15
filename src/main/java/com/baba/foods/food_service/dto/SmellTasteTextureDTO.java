package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import com.baba.foods.food_service.entity.Smell;
import com.baba.foods.food_service.entity.Taste;
import com.baba.foods.food_service.entity.Texture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmellTasteTextureDTO {

    private Smell smell;
    private Taste taste;
    private Texture texture;

}
