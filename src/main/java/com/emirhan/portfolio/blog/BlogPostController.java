package com.emirhan.portfolio.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog")
public class BlogPostController {

    private  final BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPostDTO>> getAllBlogPosts(){
        return ResponseEntity.ok(blogPostService.getAllBlogPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDTO> getBlogPostById(@PathVariable Long id){
        return ResponseEntity.ok(blogPostService.getBlogPostsById(id));
    }

    @PostMapping
    public ResponseEntity<BlogPostDTO> createBlogPost(@RequestBody BlogPostDTO dto){
        return ResponseEntity.ok(blogPostService.createBlogPost(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPostDTO> updateBlogPost(@RequestBody BlogPostDTO dto,@PathVariable Long id){
        return ResponseEntity.ok(blogPostService.updateBlogPost(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id){
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }

}
