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
    @JsonIgnoreProperties("appearances")
    private Food food;
}
