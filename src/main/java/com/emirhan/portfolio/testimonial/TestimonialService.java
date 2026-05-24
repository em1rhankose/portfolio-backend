package com.emirhan.portfolio.testimonial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public List<TestimonialDTO> getAllTestimonials(){
        List<Testimonial> testimonials = testimonialRepository.findAllByVisibleTrue();

        return testimonials.stream().map(testimonial -> TestimonialDTO.builder().id(testimonial.getId()).clientName(testimonial.getClientName()).comment(testimonial.getComment()).companyOrPosition(testimonial.getCompanyOrPosition()).photoUrl(testimonial.getPhotoUrl()).visible(testimonial.isVisible()).build()).toList();
    }

    public TestimonialDTO createTestimonial(TestimonialDTO dto){
        Testimonial emptyTestimonial = Testimonial.builder().clientName(dto.getClientName()).comment(dto.getComment()).companyOrPosition(dto.getCompanyOrPosition()).photoUrl(dto.getPhotoUrl()).visible(dto.isVisible()).build();

        Testimonial savedTestimonial = testimonialRepository.save(emptyTestimonial);

        return TestimonialDTO.builder().id(savedTestimonial.getId()).clientName(savedTestimonial.getClientName()).comment(savedTestimonial.getComment()).companyOrPosition(savedTestimonial.getCompanyOrPosition()).photoUrl(savedTestimonial.getPhotoUrl()).visible(savedTestimonial.isVisible()).build();
    }

    public TestimonialDTO updateTestimonial(Long id, TestimonialDTO dto){
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow(() -> new RuntimeException("Testimonial Not Found"));

        testimonial.setClientName(dto.getClientName());
        testimonial.setComment(dto.getComment());
        testimonial.setCompanyOrPosition(dto.getCompanyOrPosition());
        testimonial.setPhotoUrl(dto.getPhotoUrl());
        testimonial.setVisible(dto.isVisible());

        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        return TestimonialDTO.builder().id(savedTestimonial.getId()).clientName(savedTestimonial.getClientName()).comment(savedTestimonial.getComment()).companyOrPosition(savedTestimonial.getCompanyOrPosition()).photoUrl(savedTestimonial.getPhotoUrl()).visible(savedTestimonial.isVisible()).build();
    }

    public void deleteTestimonial(Long id){
        testimonialRepository.deleteById(id);
    }



}
