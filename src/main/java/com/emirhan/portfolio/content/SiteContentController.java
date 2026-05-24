package com.emirhan.portfolio.content;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class SiteContentController {

    private final SiteContentService siteContentService;

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContents(){
        return ResponseEntity.ok(siteContentService.getAllContents());
    }

    @GetMapping("/{key}")
    public ResponseEntity<ContentDTO> getContentByKey(@PathVariable String key){
        return ResponseEntity.ok(siteContentService.getContentByKey(key));
    }

    @PostMapping
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO dto){
        return ResponseEntity.ok(siteContentService.createContent(dto));
    }

    @PutMapping("/{key}")
    public ResponseEntity<ContentDTO> updateContent(@PathVariable String key,@RequestBody ContentDTO dto){
        return ResponseEntity.ok(siteContentService.updateContent(key, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id){
        siteContentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }

}
