package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "preparation_time")
public class PreparationTime implements SuperEntity {

    /**
     * Country of origin (Place of Origin): Where the food was produced or manufactured.
     * (Country, State, Province, District and address)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "preparation_time_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * time counts in minutes
     */

    @Column(name = "time")
    private Integer time;

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
    @JsonIgnoreProperties("preparationTime")
    private Food food;
}
