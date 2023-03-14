package com.baba.foods.food_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "dietaryRestriction", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("dietaryRestriction")
    private Set<Food> foods;
}
