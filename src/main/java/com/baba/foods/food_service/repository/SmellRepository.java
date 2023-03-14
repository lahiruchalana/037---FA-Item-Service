package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.Smell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmellRepository extends JpaRepository<Smell, Long> {

}
