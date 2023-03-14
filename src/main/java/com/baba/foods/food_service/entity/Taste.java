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
@Table(name = "taste")
public class Taste implements SuperEntity {

    /**
     * Taste: This includes the flavor, sweetness, saltiness, bitterness, and umami (savory) taste of the food.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "taste_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_of_taste")
    private String listOfTaste;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("taste")
    private Food food;

}
