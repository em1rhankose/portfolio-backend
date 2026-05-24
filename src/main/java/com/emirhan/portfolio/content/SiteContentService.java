package com.emirhan.portfolio.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiteContentService {

    private final SiteContentRepository siteContentRepository;

    public List<ContentDTO> getAllContents(){

        List<SiteContent> siteContents = siteContentRepository.findAll();
        return siteContents.stream().map(siteContent -> ContentDTO.builder().id(siteContent.getId()).key(siteContent.getKey()).value(siteContent.getValue()).contentType(siteContent.getContentType()).build()).toList();

    }

    public ContentDTO getContentByKey(String key){
        SiteContent content = siteContentRepository.findByKey(key).orElseThrow(() -> new RuntimeException("Content not found"));

        return ContentDTO.builder().id(content.getId()).key(content.getKey()).value(content.getValue()).contentType(content.getContentType()).build();
    }

    public ContentDTO createContent(ContentDTO dto){
        SiteContent emptyContent = SiteContent.builder().key(dto.getKey()).value(dto.getValue()).contentType(dto.getContentType()).build();

        SiteContent savedContent = siteContentRepository.save(emptyContent);

        return ContentDTO.builder().id(savedContent.getId()).key(savedContent.getKey()).value(savedContent.getValue()).contentType(savedContent.getContentType()).build();

    }

    public ContentDTO updateContent(String key, ContentDTO dto){
        SiteContent content = siteContentRepository.findByKey(key).orElseThrow(() -> new RuntimeException("Content not found"));

        content.setKey(dto.getKey());
        content.setValue(dto.getValue());
        content.setContentType(dto.getContentType());

        SiteContent updatedContent = siteContentRepository.save(content);

        return ContentDTO.builder().id(updatedContent.getId()).key(updatedContent.getKey()).value(updatedContent.getValue()).contentType(updatedContent.getContentType()).build();

    }

    public void deleteContent(Long id){
        siteContentRepository.deleteById(id);
    }


}
