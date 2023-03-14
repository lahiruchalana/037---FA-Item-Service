package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.CookingInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookingInstructionRepository extends JpaRepository<CookingInstruction, Long> {

}
