package com.example.item_service.entity;

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
@Table(name = "nutrition_serving_size")
public class NutritionServingSize implements SuperEntity {

    /**
     * Display the Quantities of nutrition from the food on one serving
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "additives_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_of_additives")
    private String listOfAdditives;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "nutrition_measuring_type_id", referencedColumnName = "id")
    private NutritionMeasuringType nutritionMeasuringType;

}
