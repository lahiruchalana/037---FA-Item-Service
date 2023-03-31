package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.configuration.customAnnotations.NotEmptyOrNull;
import com.baba.foods.food_service.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long id;
    @NotEmptyOrNull(message = "Name Must Not Be Empty")
    private String name;
    private DietaryRestriction dietaryRestriction;
    private CuisineType cuisineType;
    private Course course;
    private CookingMethod cookingMethod;
    private Set<Theme> themes;
    private Set<Allergen> allergens;
    private ExpirationOrBestBefore expirationOrBestBefore;
    private Set<CookingInstruction> cookingInstructions;
    private FoodDescription foodDescription;
    private Set<HealthClaim> healthClaims;
    private Set<Image> images;
    private Set<Ingredient> ingredients;
    private Set<ServingSize> quantities;
    private Set<NutritionInformation> nutritionInformationSet;
    private Set<Packaging> packagingSet;
    private Set<PlaceOfOrigin> placeOfOriginSet;
    private PreparationTime preparationTime;
    private Additive additives;
    private Set<Appearance> appearances;
    private Availability availability;
    private Set<NutritionServingSize> nutritionServingSizes;
    private Portion portion;
    private Smell smell;
    private Set<StorageInstruction> storageInstructions;
    private Taste taste;
    private Texture texture;
    private Date createdDate;
    private Date updatedDate;

}
