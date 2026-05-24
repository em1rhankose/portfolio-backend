package com.emirhan.portfolio.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public List<ContactInfoDTO> getAllContactInfo(){
        List<ContactInfo> allInfos = contactInfoRepository.findAllByVisibleTrue();
        return allInfos.stream().map(contactInfo -> ContactInfoDTO.builder().id(contactInfo.getId()).platform(contactInfo.getPlatform()).url(contactInfo.getUrl()).icon(contactInfo.getIcon()).visible(contactInfo.isVisible()).build()).toList();
    }

    public ContactInfoDTO createContactInfo(ContactInfoDTO dto){
        ContactInfo emptyInfo = ContactInfo.builder().platform(dto.getPlatform()).url(dto.getUrl()).icon(dto.getIcon()).visible(dto.isVisible()).build();

        ContactInfo savedInfo = contactInfoRepository.save(emptyInfo);

        return ContactInfoDTO.builder().platform(savedInfo.getPlatform()).url(savedInfo.getUrl()).icon(savedInfo.getIcon()).visible(savedInfo.isVisible()).build();
    }

    public ContactInfoDTO updateContactInfo(Long id, ContactInfoDTO dto){
        ContactInfo contactInfo = contactInfoRepository.findById(id).orElseThrow( () -> new RuntimeException("Contact Not Found"));
        contactInfo.setUrl(dto.getUrl());
        contactInfo.setIcon(dto.getIcon());
        contactInfo.setPlatform(dto.getPlatform());
        contactInfo.setVisible(dto.isVisible());
        ContactInfo updatedContactInfo = contactInfoRepository.save(contactInfo);

        return ContactInfoDTO.builder().id(updatedContactInfo.getId()).platform(updatedContactInfo.getPlatform()).url(updatedContactInfo.getUrl()).icon(updatedContactInfo.getIcon()).visible(updatedContactInfo.isVisible()).build();
    }

    public void deleteContactInfo(Long id){
        contactInfoRepository.deleteById(id);
    }



}
