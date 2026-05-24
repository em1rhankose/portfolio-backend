package com.emirhan.portfolio.playlist;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistVideoService {

    private final PlaylistVideoRepository playlistVideoRepository;

    public List<PlaylistVideoDTO> getVideosByPlaylistId(Long playlistId){
        List<PlaylistVideo> playlistVideos = playlistVideoRepository.findAllByPlaylistIdOrderByOrderIndexAsc(playlistId);

        return playlistVideos.stream().map( playlistVideo -> PlaylistVideoDTO.builder().id(playlistVideo.getId()).playlistId(playlistVideo.getPlaylistId()).youtubeId(playlistVideo.getYoutubeId()).title(playlistVideo.getTitle()).description(playlistVideo.getDescription()).orderIndex(playlistVideo.getOrderIndex()).build()).toList();
    }

    public PlaylistVideoDTO createVideo(PlaylistVideoDTO dto){
        PlaylistVideo emptyVideo = PlaylistVideo.builder().playlistId(dto.getPlaylistId()).youtubeId(dto.getYoutubeId()).title(dto.getTitle()).description(dto.getDescription()).orderIndex(dto.getOrderIndex()).build();

        PlaylistVideo savedVideo = playlistVideoRepository.save(emptyVideo);

        return PlaylistVideoDTO.builder().id(savedVideo.getId()).playlistId(savedVideo.getPlaylistId()).youtubeId(savedVideo.getYoutubeId()).title(savedVideo.getTitle()).description(savedVideo.getDescription()).orderIndex(savedVideo.getOrderIndex()).build();
    }

    public PlaylistVideoDTO updateVideo(Long id, PlaylistVideoDTO dto){
        PlaylistVideo video =  playlistVideoRepository.findById(id).orElseThrow( () -> new RuntimeException("Video Not Found"));

        video.setPlaylistId(dto.getPlaylistId());
        video.setYoutubeId(dto.getYoutubeId());
        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDescription());
        video.setOrderIndex(dto.getOrderIndex());

        PlaylistVideo updatedVideo = playlistVideoRepository.save(video);

        return PlaylistVideoDTO.builder().id(updatedVideo.getId()).playlistId(updatedVideo.getPlaylistId()).youtubeId(updatedVideo.getYoutubeId()).title(updatedVideo.getTitle()).description(updatedVideo.getDescription()).orderIndex(updatedVideo.getOrderIndex()).build();
    }

    public void deleteVideo(Long id){
        playlistVideoRepository.deleteById(id);
    }

}
