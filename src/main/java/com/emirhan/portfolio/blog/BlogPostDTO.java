package com.emirhan.portfolio.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDTO {

    private Long id;

    private String title;

    private String description;

    private String youtubeId;

    private String thumbnailUrl;

    private LocalDateTime publishedAt;

    private boolean visible;

}


