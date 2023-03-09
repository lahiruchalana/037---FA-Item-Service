package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDTO {

    private Long id;
    private AvailabilityStatus status;
    private String createdAt;
    private String updatedAt;
    private Long foodId;

}
