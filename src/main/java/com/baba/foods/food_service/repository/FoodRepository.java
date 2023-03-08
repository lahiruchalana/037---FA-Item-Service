package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {


}
