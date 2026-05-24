package com.emirhan.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<ServiceDTO> getAllServices(){
        List<FreelanceService> allServices = serviceRepository.findAllByOrderByOrderIndexAsc();

        return allServices.stream().map(service -> ServiceDTO.builder().id(service.getId()).title(service.getTitle()).description(service.getDescription()).icon(service.getIcon()).orderIndex(service.getOrderIndex()).visible(service.isVisible()).build()).toList();

    }

    public ServiceDTO createService(ServiceDTO dto){
        FreelanceService emptyService = FreelanceService.builder().title(dto.getTitle()).description(dto.getDescription()).icon(dto.getIcon()).orderIndex(dto.getOrderIndex()).visible(dto.isVisible()).build();

        FreelanceService saved = serviceRepository.save(emptyService);

        return ServiceDTO.builder().id(saved.getId()).title(saved.getTitle()).description(saved.getDescription()).icon(saved.getIcon()).orderIndex(saved.getOrderIndex()).visible(saved.isVisible()).build();
    }

    public ServiceDTO updateService(ServiceDTO dto, Long id){
        FreelanceService service = serviceRepository.findById(id).orElseThrow( () -> new RuntimeException("Service Not Found"));
        service.setTitle(dto.getTitle());
        service.setDescription(dto.getDescription());
        service.setIcon(dto.getIcon());
        service.setOrderIndex(dto.getOrderIndex());
        service.setVisible(dto.isVisible());
        FreelanceService savedService = serviceRepository.save(service);

        return ServiceDTO.builder().id(savedService.getId()).title(savedService.getTitle()).description(savedService.getDescription()).icon(savedService.getIcon()).orderIndex(savedService.getOrderIndex()).visible(savedService.isVisible()).build();
    }

    public void deleteService(Long id){
        serviceRepository.deleteById(id);
    }

}
