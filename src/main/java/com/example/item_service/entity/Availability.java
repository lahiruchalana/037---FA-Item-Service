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
     * Active or Inactive
     */

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

}
