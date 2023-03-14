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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("additive")
    private Food food;
}
