package com.emirhan.portfolio.playlist;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDTO {

    private Long id;

    private String title;

    private String description;

    private String thumbnailUrl;

    private int orderIndex;

    private boolean visible;


}
