package com.example.item_service.entity;

import com.example.item_service.common.TimeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expiration_or_best_before")
public class ExpirationOrBestBefore {

    /**
     * Expiration or Best Before Date: The date by which the food should be consumed for optimal quality and safety.
     *
     *      Understand that we only add the expiration time or days (not the dates) Ex - best before 24 hours/ 2 days/ within one week
     *      not the 2023/02/26 to 2023/03/05
     *      not the expiration date - 2023/03/09
     * **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "course_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "time_type")
    private TimeType timeType;

    @Column(name = "time")
    private Integer time;

    @Column(name = "note_about_expiration")
    private String noteAboutExpiration;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}
