package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.AvailabilityStatus;
import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDTO {

    private Long id;
    @NotEmptyOrNull(message = "Status Must Not Be Empty")
    private AvailabilityStatus status;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Long foodId;

}
