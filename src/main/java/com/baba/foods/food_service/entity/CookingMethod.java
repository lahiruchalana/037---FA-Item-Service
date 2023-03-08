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
@Table(name = "cooking_method")
public class CookingMethod implements SuperEntity {

    /**
     * Cooking Method: This refers to the way the food is prepared, such as grilled, roasted, fried, or baked.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cooking_method_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "method")
    private String method;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "cookingMethod", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Food> foods;
}
