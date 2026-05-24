package com.emirhan.portfolio.playlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistVideoRepository extends JpaRepository<PlaylistVideo,Long> {

    List<PlaylistVideo> findAllByPlaylistIdOrderByOrderIndexAsc(Long playlistId);


}
