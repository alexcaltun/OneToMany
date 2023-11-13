package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "info", schema="unihack")
public class Info {

    @Id
    private Long infoId;

    private String type;
    private float quantity;
    private int border;
    private float quantityUntilBonus;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;



}
