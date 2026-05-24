package com.emirhan.portfolio.playlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public List<PlaylistDTO> getAllPlaylists(){
        List<Playlist> playlists = playlistRepository.findAllByOrderByOrderIndexAsc();
        return playlists.stream().map( playlist -> PlaylistDTO.builder().id(playlist.getId()).title(playlist.getTitle()).description(playlist.getDescription()).thumbnailUrl(playlist.getThumbnailUrl()).orderIndex(playlist.getOrderIndex()).visible(playlist.isVisible()).build()).toList();
    }

    public PlaylistDTO getplaylistById(Long id){
        Playlist playlist = playlistRepository.findById(id).orElseThrow( () -> new RuntimeException("Playlist Not Found"));

        return PlaylistDTO.builder().id(playlist.getId()).title(playlist.getTitle()).description(playlist.getDescription()).thumbnailUrl(playlist.getThumbnailUrl()).orderIndex(playlist.getOrderIndex()).visible(playlist.isVisible()).build();
    }

    public PlaylistDTO createPlaylist(PlaylistDTO dto){
        Playlist emptyPlaylist = Playlist.builder().title(dto.getTitle()).description(dto.getDescription()).thumbnailUrl(dto.getThumbnailUrl()).orderIndex(dto.getOrderIndex()).visible(dto.isVisible()).build();

        Playlist savedPlaylist = playlistRepository.save(emptyPlaylist);

        return PlaylistDTO.builder().id(savedPlaylist.getId()).title(savedPlaylist.getTitle()).description(savedPlaylist.getDescription()).thumbnailUrl(savedPlaylist.getThumbnailUrl()).orderIndex(savedPlaylist.getOrderIndex()).visible(savedPlaylist.isVisible()).build();
    }

    public PlaylistDTO updatePlaylist(Long id, PlaylistDTO dto){
        Playlist playlist = playlistRepository.findById(id).orElseThrow( () -> new RuntimeException("playlist not found!") );

        playlist.setTitle(dto.getTitle());
        playlist.setDescription(dto.getDescription());
        playlist.setThumbnailUrl(dto.getThumbnailUrl());
        playlist.setOrderIndex(dto.getOrderIndex());
        playlist.setVisible(dto.isVisible());
        Playlist updatedPlaylist = playlistRepository.save(playlist);

            return PlaylistDTO.builder().id(updatedPlaylist.getId()).title(updatedPlaylist.getTitle()).description(updatedPlaylist.getDescription()).thumbnailUrl(updatedPlaylist.getThumbnailUrl()).orderIndex(updatedPlaylist.getOrderIndex()).visible(updatedPlaylist.isVisible()).build();
    }

    public void deletePlaylist(Long id){
        playlistRepository.deleteById(id);
    }

}
