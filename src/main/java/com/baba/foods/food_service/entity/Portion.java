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
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "portion_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * numberOfPortion - how many persons can eat the food at once ordered.
     */

    @Column(name = "number_of_portion")
    private Double numberOfPortion;

    @Column(name = "quantity")
    private String quantity;

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
    @JsonIgnoreProperties("portion")
    private Food food;

}
