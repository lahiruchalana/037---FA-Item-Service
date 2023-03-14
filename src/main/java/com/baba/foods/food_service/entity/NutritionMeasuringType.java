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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "nutritionMeasuringType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("nutritionMeasuringType")
    private Set<NutritionServingSize> nutritionServingSizes;
}
