package com.baba.foods.food_service.repository;

import com.baba.foods.food_service.entity.Texture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextureRepository extends JpaRepository<Texture, Long> {

}
