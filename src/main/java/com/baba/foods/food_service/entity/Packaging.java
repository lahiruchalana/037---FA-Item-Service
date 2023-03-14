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
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packaging")
public class Packaging implements SuperEntity {

    /**
     * Packaging: The type of packaging used for the food, including materials and recyclable information.
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "packaging_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Packaging type can be a string -> vendors or employees can type any package type
     */

    @Column(name = "packaging_type")
    private String packagingType;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("packagingSet")
    private Food food;
}
