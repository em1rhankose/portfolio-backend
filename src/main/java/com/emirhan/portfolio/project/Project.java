package com.emirhan.portfolio.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column
    private String imageUrl;

    @Column
    private String githubUrl;

    @Column
    private String liveUrl;

    @Column(nullable = false)
    private String tags;

    @Column(nullable = false)
    private int orderIndex;

    @Column(nullable = false)
    private boolean visible;

    @Column(columnDefinition = "TEXT")
    private String detailContent;

    @Column
    private Long blogPostId;


}
