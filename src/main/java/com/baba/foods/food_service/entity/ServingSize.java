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
@Table(name = "serving_size")
public class ServingSize implements SuperEntity {

    /**
     * Display the Quantity of the food per one serving
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "serving_size_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size")
    private Double size;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    /**
     * There may exist two or more quantities from different measuringTypes
     * Ex - 453g or 1 pound
     */

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("quantities")
    private Food food;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "measuring_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("servingSize")
    private MeasuringType measuringType;
}
