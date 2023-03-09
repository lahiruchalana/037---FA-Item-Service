package com.baba.foods.food_service.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cooking_instruction")
public class CookingInstruction implements SuperEntity {

    /**
     * For partially cooked or non-cooked foods
     * Cooking Instructions: How to prepare or cook the food, including temperature and time instructions.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cooking_instruction_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "number")
    private Integer number;

    /**
     * order = 1 means first instruction
     * order = 2 means second instruction
     * order = 3 means third instruction
     * order = 4 means fourth instruction
     */

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
