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

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

}
