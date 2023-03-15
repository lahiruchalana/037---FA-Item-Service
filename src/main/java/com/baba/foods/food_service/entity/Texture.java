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
@Table(name = "texture")
public class Texture implements SuperEntity {

    /**
     * Texture: This includes the mouthfeel of the food, such as its softness, crunchiness, or chewiness.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "texture_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_of_texture")
    private String listOfTexture;

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
    @JsonIgnoreProperties("texture")
    private Food food;

}
