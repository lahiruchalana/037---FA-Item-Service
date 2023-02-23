package com.example.item_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food")
public class Food implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "dietary_restrictions_id", referencedColumnName = "id")
    private DietaryRestriction dietaryRestrictions;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "cuisine_type_id", referencedColumnName = "id")
    private CuisineType cuisineType;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "cooking_method_id", referencedColumnName = "id")
    private CookingMethod cookingMethod;

//    private Theme (many to many)

}
