package com.emirhan.portfolio.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private String githubUrl;

    private String liveUrl;

    private String tags;

    private int orderIndex;

    private boolean visible;

    private Long blogPostId;

    private String detailContent;

}
