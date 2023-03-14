package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.TimeType;
import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpirationOrBestBeforeDTO {

    private Long id;
    private TimeType timeType;
    private String time;
    private String noteAboutExpiration;
    private Date createdDate;
    private Date updatedDate;
    private Food food;

}

