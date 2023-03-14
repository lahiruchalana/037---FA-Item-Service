package com.baba.foods.food_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppearanceDTO {

    private Long id;
    private String appearanceType;
    private String value;
    private Date createdDate;
    private Date updatedDate;
    private Long foodId;

}
