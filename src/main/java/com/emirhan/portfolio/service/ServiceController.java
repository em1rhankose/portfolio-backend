package com.emirhan.portfolio.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAllServices(){
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PostMapping
    public ResponseEntity<ServiceDTO> createService(@RequestBody ServiceDTO dto){

        return ResponseEntity.ok(serviceService.createService(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> updateService(@PathVariable Long id, @RequestBody ServiceDTO dto){
        return ResponseEntity.ok(serviceService.updateService(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id){
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }


}
