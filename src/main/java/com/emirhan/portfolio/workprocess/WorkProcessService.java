package com.emirhan.portfolio.workprocess;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkProcessService {

    private final WorkProcessRepository workProcessRepository;

    public List<WorkProcessDTO> getAllWorkProcesses(){

        List<WorkProcess> workProcesses = workProcessRepository.findAllByOrderByStepNumberAsc();

        return workProcesses.stream().map( workProcess -> WorkProcessDTO.builder().id(workProcess.getId()).stepNumber(workProcess.getStepNumber()).title(workProcess.getTitle()).description(workProcess.getDescription()).visible(workProcess.isVisible()).build()).toList();

    }

    public WorkProcessDTO createWorkProcess(WorkProcessDTO dto){
        WorkProcess emptyWorkProcess = WorkProcess.builder().stepNumber(dto.getStepNumber()).title(dto.getTitle()).description(dto.getDescription()).visible(dto.isVisible()).build();

        WorkProcess savedWorkProcess = workProcessRepository.save(emptyWorkProcess);

        return WorkProcessDTO.builder().id(savedWorkProcess.getId()).stepNumber(savedWorkProcess.getStepNumber()).title(savedWorkProcess.getTitle()).description(savedWorkProcess.getDescription()).visible(savedWorkProcess.isVisible()).build();

    }

    public WorkProcessDTO updateWorkProcess(Long id, WorkProcessDTO dto){
        WorkProcess workProcess = workProcessRepository.findById(id).orElseThrow(() -> new RuntimeException("Work Process Not Found!"));

        workProcess.setStepNumber(dto.getStepNumber());
        workProcess.setTitle(dto.getTitle());
        workProcess.setDescription(dto.getDescription());
        workProcess.setVisible(dto.isVisible());

        WorkProcess savedWorkProcess = workProcessRepository.save(workProcess);

        return WorkProcessDTO.builder().id(savedWorkProcess.getId()).stepNumber(savedWorkProcess.getStepNumber()).title(savedWorkProcess.getTitle()).description(savedWorkProcess.getDescription()).visible(savedWorkProcess.isVisible()).build();

    }

    public void deleteWorkProcess(Long id){
        workProcessRepository.deleteById(id);
    }

}
