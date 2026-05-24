package com.emirhan.portfolio.workprocess;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/work-process")
public class WorkProcessController {

    private final WorkProcessService workProcessService;

    @GetMapping
    public ResponseEntity<List<WorkProcessDTO>> getAllWorkProcesses(){
        return ResponseEntity.ok(workProcessService.getAllWorkProcesses());
    }

    @PostMapping
    public ResponseEntity<WorkProcessDTO> createWorkProcess(@RequestBody WorkProcessDTO dto){
        return ResponseEntity.ok(workProcessService.createWorkProcess(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkProcessDTO> updateWorkProcess(@PathVariable Long id, @RequestBody WorkProcessDTO dto){
        return ResponseEntity.ok(workProcessService.updateWorkProcess(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkProcess(@PathVariable Long id){
        workProcessService.deleteWorkProcess(id);
        return ResponseEntity.noContent().build();
    }




}
