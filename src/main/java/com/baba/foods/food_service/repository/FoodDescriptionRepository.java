package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.FoodDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDescriptionRepository extends JpaRepository<FoodDescription, Long> {

}
