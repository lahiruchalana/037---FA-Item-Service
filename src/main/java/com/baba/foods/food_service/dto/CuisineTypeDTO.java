package com.baba.foods.food_service.dto;

import com.baba.foods.food_service.entity.Food;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuisineTypeDTO {


    private Long id;
    private String type;
    private Date createdDate;
    private Date updatedDate;
    private Set<Food> foods;

}
