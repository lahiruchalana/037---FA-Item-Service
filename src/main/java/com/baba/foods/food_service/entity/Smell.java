package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "smell")
public class Smell implements SuperEntity {

    /**
     * Smell: This includes the aroma and fragrance of the food.
     * Cheese
     * Garlic
     * Onion
     * Oil
     * Olive
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "smell_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "smell_name")
    private String smellName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("smell")
    private Food food;

}
