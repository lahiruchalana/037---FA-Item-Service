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

    @Column(name = "value")
    private Integer value;

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
    @JsonIgnoreProperties("nutritionServingSizes")
    private Food food;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "nutrition_measuring_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("nutritionServingSizes")
    private NutritionMeasuringType nutritionMeasuringType;

}
