package com.baba.foods.food_service.dto.response;

import com.baba.foods.food_service.entity.Smell;
import com.baba.foods.food_service.entity.Taste;
import com.baba.foods.food_service.entity.Texture;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmellTasteTextureResponseDTO {

    @JsonIgnoreProperties("food")
    private Smell smell;

    @JsonIgnoreProperties("food")
    private Taste taste;

    @JsonIgnoreProperties("food")
    private Texture texture;
}
