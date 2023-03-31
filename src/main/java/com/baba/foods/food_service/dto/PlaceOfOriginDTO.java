package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.common.OriginStatus;
import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOfOriginDTO {

    private Long id;
    @NotEmptyOrNull(message = "OriginStatus Must Not Be Empty")
    private OriginStatus originStatus;
    @NotEmptyOrNull(message = "Country Must Not Be Empty")
    private String country;
    @NotEmptyOrNull(message = "ProvinceOrState Must Not Be Empty")
    private String provinceOrState;
    @NotEmptyOrNull(message = "District Must Not Be Empty")
    private String district;
    @NotEmptyOrNull(message = "AddressLineOne Must Not Be Empty")
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private Date createdDate;
    private Date updatedDate;
    @NotEmptyOrNull(message = "Food Must Not Be Empty")
    private Food food;

}
