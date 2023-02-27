package com.example.item_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packaging")
public class Packaging {

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

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
