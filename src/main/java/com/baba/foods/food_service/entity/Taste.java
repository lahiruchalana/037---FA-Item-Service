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
    @JsonIgnoreProperties("taste")
    private Food food;

}
