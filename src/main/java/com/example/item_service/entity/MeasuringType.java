package com.example.item_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measuring_type")
public class MeasuringType implements SuperEntity {

    /**
     * Type - Volume, Weight, Count, Length, Energy, Sugar, salt, Oil, Protein, Fat,  Vitamin, Fiber, Minerals
     * MetricUnit - kg, g, l, ml, ounces, pounds, calories,
     * **/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "measuring_type_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "metric_unit")
    private String metricUnit;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "measuringType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ServingSize> servingSize;
}
