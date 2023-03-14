package com.baba.foods.food_service.entity;

import com.baba.foods.food_service.common.OriginStatus;
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
@Table(name = "place_of_origin")
public class PlaceOfOrigin implements SuperEntity {

    /**
     * Country of origin (Place of Origin): Where the food was produced or manufactured.
     * (Country, State, Province, District and address)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "place_of_origin_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Why originStatus? to find what type of address it is(produce, manufacture or distribute)
     */

    @Column(name = "origin_status")
    private OriginStatus originStatus;

    @Column(name = "country")
    private String country;

    @Column(name = "province_or_state")
    private String provinceOrState;

    @Column(name = "district")
    private String district;

    @Column(name = "address_line_one")
    private String addressLineOne;

    @Column(name = "address_line_two")
    private String addressLineTwo;

    @Column(name = "address_line_three")
    private String addressLineThree;

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
    @JsonIgnoreProperties("placeOfOriginSet")
    private Food food;
}
