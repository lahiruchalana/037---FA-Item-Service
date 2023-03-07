package com.example.item_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dietary_restriction")
public class DietaryRestriction implements SuperEntity{

    /**
     * Dietary Needs: This refers to foods
     * that are suitable for people with specific dietary requirements, such as gluten-free, vegetarian, or vegan.
     *
     * dietary restrictions, such as "gluten-free" or "low-fat."
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "dietary_restriction_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "restriction")
    private String restriction;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "dietaryRestriction", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Food> foods;
}
