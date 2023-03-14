package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "preparation_time")
public class PreparationTime implements SuperEntity {

    /**
     * Country of origin (Place of Origin): Where the food was produced or manufactured.
     * (Country, State, Province, District and address)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "preparation_time_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * time counts in minutes
     */

    @Column(name = "time")
    private Integer time;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("preparationTime")
    private Food food;
}
