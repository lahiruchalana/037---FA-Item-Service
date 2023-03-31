package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.NutritionInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionInformationRepository extends JpaRepository<NutritionInformation, Long> {


}
