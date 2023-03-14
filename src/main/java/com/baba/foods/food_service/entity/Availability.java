package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.baba.foods.food_service.common.AvailabilityStatus;
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
@Table(name = "availability")
public class Availability implements SuperEntity {

    /**
     * Availability: Availability of the food in relevant shops
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "availability_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * IN_STOCK, OUT_OF_STOCK
     */

    @Column(name = "status")
    private AvailabilityStatus status;

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
    @JsonIgnoreProperties("availability")
    private Food food;

}
