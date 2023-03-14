package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDTO {

    private Long id;
    private AvailabilityStatus status;
    private Date createdDate;
    private Date updatedDate;
    private Long foodId;

}
