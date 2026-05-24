package com.emirhan.portfolio.playlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistVideoDTO {

    private Long id;

    private Long playlistId;

    private String youtubeId;

    private String title;

    private String description;

    private int orderIndex;

}
