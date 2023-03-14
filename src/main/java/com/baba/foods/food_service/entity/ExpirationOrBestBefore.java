package com.baba.foods.food_service.entity;

import com.baba.foods.food_service.common.TimeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expiration_or_best_before")
public class ExpirationOrBestBefore implements SuperEntity {

    /**
     * Expiration or Best Before Date: The date by which the food should be consumed for optimal quality and safety.
     *
     *      Understand that we only add the expiration time or days (not the dates) Ex - best before 24 hours/ 2 days/ within one week
     *      not the 2023/02/26 to 2023/03/05
     *      not the expiration date - 2023/03/09
     * **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "expiration_or_best_before_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "time_type")
    private TimeType timeType;

    /**
     * Should have facility to store dates hence we are using String data type for time
     */

    @Column(name = "time")
    private String time;

    /**
     * Some special notes about the expirations -
     * Ex - when open the bottle only one day can available ( or best before use)
     */

    @Column(name = "note_about_expiration")
    private String noteAboutExpiration;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonIgnoreProperties("expirationOrBestBefore")
    private Food food;
}
