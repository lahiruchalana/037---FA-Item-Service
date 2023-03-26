package com.baba.foods.food_service.dto.response;

import com.baba.foods.food_service.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDTO {

    /**
     * only below selected properties will be shown when the page load for particular food.
     * some properties are not here available
     */
    private Long id;
    private String name;
    private DietaryRestriction dietaryRestriction;
    private CuisineType cuisineType;
    private Course course;
    private CookingMethod cookingMethod;
    private Set<Theme> themes;
    private ExpirationOrBestBefore expirationOrBestBefore;
    private FoodDescription foodDescription;
    private Set<Image> images;
    private Set<ServingSize> quantities;
    private PreparationTime preparationTime;
    private Availability availability;
    private Portion portion;
    private Date createdDate;
    private Date updatedDate;

}
