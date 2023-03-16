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
    @JsonIgnoreProperties("storageInstructions")
    private Food food;
}
