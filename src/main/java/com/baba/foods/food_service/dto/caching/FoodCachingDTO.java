package com.baba.foods.food_service.dto.caching;

import com.baba.foods.food_service.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodCachingDTO {

    /**
     * There is a caching issue with the Set<> values so here we are not going to display Set<> properties in food
     * not available Set<> properties
     */
    private Long id;
    private String name;
    private DietaryRestriction dietaryRestriction;
    private CuisineType cuisineType;
    private Course course;
    private CookingMethod cookingMethod;
    private ExpirationOrBestBefore expirationOrBestBefore;
    private FoodDescription foodDescription;
    private PreparationTime preparationTime;
    private Additive additive;
    private Availability availability;
    private Portion portion;
    private Smell smell;
    private Taste taste;
    private Texture texture;
    private Date createdDate;
    private Date updatedDate;

}
