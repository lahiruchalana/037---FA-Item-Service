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
@Table(name = "cuisine_type")
public class CuisineType implements SuperEntity {

    /**
     * Cuisine Type: This refers to the style of cooking and the cultural origins of the dishes.
     * Examples of cuisine types include Italian, Chinese, Mexican, and French.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cuisine_type_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "cuisineType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Food> foods;
}
