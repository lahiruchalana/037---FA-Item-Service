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
@Table(name = "nutrition_measuring_type")
public class NutritionMeasuringType implements SuperEntity {

    /**
     * Type - Sugar, Salt, Fat, Carbohydrates, Protein, Protein, Vitamin, Fiber, Minerals, Oil
     * MetricUnit - grams, percentage(%), mg
     * **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "nutrition_measuring_type_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "metric_unit")
    private String metricUnit;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "nutritionMeasuringType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<NutritionServingSize> nutritionServingSizes;
}
