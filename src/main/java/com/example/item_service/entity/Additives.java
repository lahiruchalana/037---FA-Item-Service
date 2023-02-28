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
@Table(name = "additives")
public class Additives implements SuperEntity {

    /**
     * Additives: As mentioned earlier, food additives are substances added
     * to foods to enhance flavor, texture, or shelf life.
     *
     * Examples of additives include preservatives, colorings, and flavorings.
     *
     *  Sodium benzoate, Potassium sorbate, Sulfites, Propionic acid
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "additives_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_of_additives")
    private String listOfAdditives;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
