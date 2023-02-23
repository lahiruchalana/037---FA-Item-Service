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
@Table(name = "dietary_restriction")
public class DietaryRestriction implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "dietary_restriction_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "restriction")
    private String restriction;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "dietaryRestriction", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Food> foods;
}
