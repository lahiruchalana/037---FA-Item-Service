package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Test, Long> {
}
