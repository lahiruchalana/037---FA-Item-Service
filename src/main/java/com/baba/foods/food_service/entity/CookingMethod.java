package com.baba.foods.food_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "cookingMethod", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Food> foods;
}
