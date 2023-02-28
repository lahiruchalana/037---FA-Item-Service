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
@Table(name = "portion")
public class Portion implements SuperEntity {

    /**
     * ServingSize: Quantities/ portions of foods are provided by restaurants for the particular price.
     *
     * Understand - this data provided for the particular price
     *
     * ******** price ********
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "serving_size_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * numberOfPortion - how many persons can eat the food at once ordered.
     */

    @Column(name = "number_of_portion")
    private Double numberOfPortion;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;


}
