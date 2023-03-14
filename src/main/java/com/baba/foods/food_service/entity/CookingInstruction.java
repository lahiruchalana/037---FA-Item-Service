package com.baba.foods.food_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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
    @JsonIgnoreProperties("cookingInstructions")
    private Food food;
}
