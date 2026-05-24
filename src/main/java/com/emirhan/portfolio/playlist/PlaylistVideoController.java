package com.emirhan.portfolio.playlist;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlist-videos")
public class PlaylistVideoController {

    private final PlaylistVideoService playlistVideoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<PlaylistVideoDTO>> getVideosByPlaylistId(@PathVariable Long id){
        return ResponseEntity.ok(playlistVideoService.getVideosByPlaylistId(id));
    }

    @PostMapping
    public ResponseEntity<PlaylistVideoDTO> createVideo(@RequestBody PlaylistVideoDTO dto){
        return ResponseEntity.ok(playlistVideoService.createVideo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistVideoDTO> updateVideo(@PathVariable Long id, @RequestBody PlaylistVideoDTO dto){
        return ResponseEntity.ok(playlistVideoService.updateVideo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id){
        playlistVideoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

}
