package com.example.item_service.entity;

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
@Table(name = "health_claim")
public class HealthClaim implements SuperEntity {

    /**
     * Health claims: Any statements or claims made about the food's health benefits
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "health_claim_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "claim")
    private String claim;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
