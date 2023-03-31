package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.TimeType;
import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
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
    @NotEmptyOrNull(message = "TimeType Must Not Be Empty")
    private TimeType timeType;
    @NotEmptyOrNull(message = "Time Must Not Be Empty")
    private String time;
    @NotEmptyOrNull(message = "NoteAboutExpiration Must Not Be Empty")
    private String noteAboutExpiration;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Food food;

}

