package com.baba.foods.food_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient implements SuperEntity{

    /**
     * Ingredients: The list of all the ingredients used to make the food, listed in order of the amount used.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ingredient_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
