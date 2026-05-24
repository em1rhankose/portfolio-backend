package com.emirhan.portfolio.playlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {

    List<Playlist> findAllByOrderByOrderIndexAsc();

}
