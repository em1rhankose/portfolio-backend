package com.emirhan.portfolio.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contact")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @GetMapping
    public ResponseEntity<List<ContactInfoDTO>> getAllContactInfo(){
        return ResponseEntity.ok(contactInfoService.getAllContactInfo());
    }

    @PostMapping
    public ResponseEntity<ContactInfoDTO> createContactInfo(@RequestBody ContactInfoDTO dto){
        return ResponseEntity.ok(contactInfoService.createContactInfo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> updateContactInfo(@PathVariable Long id, @RequestBody ContactInfoDTO dto){
        return ResponseEntity.ok(contactInfoService.updateContactInfo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInfo(@PathVariable Long id){
        contactInfoService.deleteContactInfo(id);
        return ResponseEntity.noContent().build();
    }

}
