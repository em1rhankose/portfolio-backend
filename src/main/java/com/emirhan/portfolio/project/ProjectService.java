package com.emirhan.portfolio.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectDTO> getAllProjects(){

        List<Project> allProjects = projectRepository.findAllByOrderByOrderIndexAsc();

        return allProjects.stream().map(project -> ProjectDTO.builder().id(project.getId()).detailContent(project.getDetailContent()).blogPostId(project.getBlogPostId()).title(project.getTitle()).description(project.getDescription()).imageUrl(project.getImageUrl()).githubUrl(project.getGithubUrl()).liveUrl(project.getLiveUrl()).tags(project.getTags()).orderIndex(project.getOrderIndex()).visible(project.isVisible()).build()).toList();
    }

    public ProjectDTO getProjectById(Long id){
        Project project = projectRepository.findById(id).orElseThrow( () -> new RuntimeException("Project Not Found"));

        return ProjectDTO.builder().id(project.getId()).blogPostId(project.getBlogPostId()).detailContent(project.getDetailContent()).title(project.getTitle()).description(project.getDescription()).imageUrl(project.getImageUrl()).githubUrl(project.getGithubUrl()).liveUrl(project.getLiveUrl()).tags(project.getTags()).orderIndex(project.getOrderIndex()).visible(project.isVisible()).build();
    }

    public ProjectDTO createProject(ProjectDTO dto){
        Project entity = Project.builder().title(dto.getTitle()).blogPostId(dto.getBlogPostId()).detailContent(dto.getDetailContent()).description(dto.getDescription()).imageUrl(dto.getImageUrl()).githubUrl(dto.getGithubUrl()).liveUrl(dto.getLiveUrl()).tags(dto.getTags()).orderIndex(dto.getOrderIndex()).visible(dto.isVisible()).build();

        Project saved = projectRepository.save(entity);

        return ProjectDTO.builder().title(saved.getTitle()).description(saved.getDescription()).blogPostId(saved.getBlogPostId()).detailContent(saved.getDetailContent()).imageUrl(saved.getImageUrl()).githubUrl(saved.getGithubUrl()).liveUrl(saved.getLiveUrl()).tags(saved.getTags()).orderIndex(saved.getOrderIndex()).visible(saved.isVisible()).build();
    }

    public ProjectDTO updateProject(Long id, ProjectDTO dto){
        Project project = projectRepository.findById(id).orElseThrow( () -> new RuntimeException("Project Not Found"));

        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setBlogPostId(dto.getBlogPostId());
        project.setDetailContent( dto.getDetailContent());
        project.setImageUrl(dto.getImageUrl());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveUrl(dto.getLiveUrl());
        project.setTags(dto.getTags());
        project.setOrderIndex(dto.getOrderIndex());
        project.setVisible(dto.isVisible());

        Project updatedProject = projectRepository.save(project);

        return ProjectDTO.builder().title(updatedProject.getTitle()).blogPostId(updatedProject.getBlogPostId()).detailContent(updatedProject.getDetailContent()).description(updatedProject.getDescription()).imageUrl(updatedProject.getImageUrl()).githubUrl(updatedProject.getGithubUrl()).liveUrl(updatedProject.getLiveUrl()).tags(updatedProject.getTags()).orderIndex(updatedProject.getOrderIndex()).visible(updatedProject.isVisible()).build() ;
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);

    }

}
