package com.emirhan.portfolio.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="services")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelanceService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column
    private String icon;

    @Column(nullable = false)
    private int orderIndex;

    @Column(nullable = false)
    private boolean visible;


}
