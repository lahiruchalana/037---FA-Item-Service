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
@Table(name = "allergen")
public class Allergen implements SuperEntity {

    /**
     * Allergens: Any allergens that are present in the food, such as wheat, soy, nuts, or dairy, should be clearly labeled.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "allergen_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "allergenName")
    private String allergenName;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

}
