package com.example.item_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quantity")
public class Quantity {

    /**
     * Display the Quantity of ingredient or the food
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ingredient_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantity_value")
    private Double quantityValue;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    /**
     * There may exist two or more quantities from different measuringTypes
     * Ex - 453g or 1 pound
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "measuring_type_id", referencedColumnName = "id")
    private MeasuringType measuringType;
}
