package com.baba.foods.food_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nutrition_information")
public class NutritionInformation implements SuperEntity {

    /**
     * Nutrition Information: The nutritional values of the food,
     * including the amount of calories, protein, fat, carbohydrates, vitamins, and minerals per serving.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "nutrition_information_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "information")
    private String information;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
