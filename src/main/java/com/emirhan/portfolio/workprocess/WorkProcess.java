package com.emirhan.portfolio.workprocess;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="work_process")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int stepNumber;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean visible;

}
