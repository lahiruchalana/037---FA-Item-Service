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
@Table(name = "appearance")
public class Appearance implements SuperEntity {

    /**
     * Appearance: This includes the color, size, shape, and texture of the food.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "appearance_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "appearance_type")
    private String appearanceType;

    @Column(name = "value")
    private String value;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("appearances")
    private Food food;
}
