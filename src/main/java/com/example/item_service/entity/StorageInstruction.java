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
@Table(name = "storage_instruction")
public class StorageInstruction implements SuperEntity {

    /**
     * Storage Instructions: How the food should be stored, such as in a cool, dry place or refrigerated.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "storage_instruction_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
