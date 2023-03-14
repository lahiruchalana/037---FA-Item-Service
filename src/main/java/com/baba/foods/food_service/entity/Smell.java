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
@Table(name = "smell")
public class Smell implements SuperEntity {

    /**
     * Smell: This includes the aroma and fragrance of the food.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "smell_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "smell_name")
    private String smellName;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("smell")
    private Food food;

}
