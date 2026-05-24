package com.emirhan.portfolio.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public List<BlogPostDTO> getAllBlogPosts(){
        List<BlogPost> allBlogPosts = blogPostRepository.findAllByVisibleTrue();

        return allBlogPosts.stream().map(blogPost -> BlogPostDTO.builder().id(blogPost.getId()).title(blogPost.getTitle()).description(blogPost.getDescription()).youtubeId(blogPost.getYoutubeId()).thumbnailUrl(blogPost.getThumbnailUrl()).publishedAt(blogPost.getPublishedAt()).visible(blogPost.isVisible()).build()).toList();
    }

    public BlogPostDTO getBlogPostsById(Long id){
        BlogPost blogPost =  blogPostRepository.findById(id).orElseThrow( () -> new RuntimeException("BlogPost Not Found"));

        return BlogPostDTO.builder().id(blogPost.getId()).title(blogPost.getTitle()).description(blogPost.getDescription()).youtubeId(blogPost.getYoutubeId()).thumbnailUrl(blogPost.getThumbnailUrl()).publishedAt(blogPost.getPublishedAt()).visible(blogPost.isVisible()).build();
    }

    public BlogPostDTO createBlogPost(BlogPostDTO dto){
        BlogPost entityBlog = BlogPost.builder().title(dto.getTitle()).description(dto.getDescription()).youtubeId(dto.getYoutubeId()).thumbnailUrl(dto.getThumbnailUrl()).publishedAt(dto.getPublishedAt()).visible(dto.isVisible()).build();

        BlogPost saved = blogPostRepository.save(entityBlog);

        return BlogPostDTO.builder().id(saved.getId()).title(saved.getTitle()).description(saved.getDescription()).youtubeId(saved.getYoutubeId()).thumbnailUrl(saved.getThumbnailUrl()).publishedAt(saved.getPublishedAt()).visible(saved.isVisible()).build();
    }

    public BlogPostDTO updateBlogPost(Long id, BlogPostDTO dto){
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow( () -> new RuntimeException("BlogPost Not Found"));
        blogPost.setTitle(dto.getTitle());
        blogPost.setDescription(dto.getDescription());
        blogPost.setYoutubeId(dto.getYoutubeId());
        blogPost.setThumbnailUrl(dto.getThumbnailUrl());
        blogPost.setPublishedAt(dto.getPublishedAt());
        blogPost.setVisible(dto.isVisible());

        BlogPost saved = blogPostRepository.save(blogPost);

        return BlogPostDTO.builder().id(saved.getId()).title(saved.getTitle()).description(saved.getDescription()).youtubeId(saved.getYoutubeId()).thumbnailUrl(saved.getThumbnailUrl()).publishedAt(saved.getPublishedAt()).visible(saved.isVisible()).build();
    }

    public void deleteBlogPost(Long id){
        blogPostRepository.deleteById(id);
    }

}
