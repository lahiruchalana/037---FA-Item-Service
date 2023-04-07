package com.baba.foods.food_service.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class Test implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "test_seq_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "test_one")
    private Integer testOne;

    @Column(name = "test_two", updatable = false)
    private Integer testTwo;
}
