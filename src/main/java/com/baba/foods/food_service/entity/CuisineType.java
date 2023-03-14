package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "cuisineType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("cuisineType")
    private Set<Food> foods;
}
