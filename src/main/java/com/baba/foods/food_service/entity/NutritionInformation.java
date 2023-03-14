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
@Table(name = "nutrition_information")
public class NutritionInformation implements SuperEntity {

    /**
     *
     * Nutrition Information: The nutritional values of the food,
     * including the amount of calories, protein, fat, carbohydrates, vitamins, and minerals per serving.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "nutrition_information_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "information")
    private String information;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("nutritionInformationSet")
    private Food food;
}
