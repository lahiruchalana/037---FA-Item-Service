package com.baba.foods.food_service.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
    @JsonIgnoreProperties("allergens")
    private Food food;

}
