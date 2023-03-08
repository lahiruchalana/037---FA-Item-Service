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
@Table(name = "food_description")
public class FoodDescription implements SuperEntity {

    /**
     *  write a description about the food
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_description_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "main_description")
    private String mainDescription;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
