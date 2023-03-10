package com.baba.foods.food_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "additive")
public class Additive implements SuperEntity {

    /**
     * Additives: As mentioned earlier, food additives are substances added
     * to foods to enhance flavor, texture, or shelf life.
     *
     * Examples of additives include preservatives, colorings, and flavorings.
     *
     *  Sodium benzoate, Potassium sorbate, Sulfites, Propionic acid
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "additive_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_of_additives")
    private String listOfAdditives;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
