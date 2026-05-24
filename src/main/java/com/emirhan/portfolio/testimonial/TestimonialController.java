package com.emirhan.portfolio.testimonial;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService testimonialService;

    @GetMapping
    public ResponseEntity<List<TestimonialDTO>> getAllTestimonials(){
        return ResponseEntity.ok(testimonialService.getAllTestimonials());
    }

    @PostMapping
    public ResponseEntity<TestimonialDTO> createTestimonial(@RequestBody TestimonialDTO dto){
        return ResponseEntity.ok(testimonialService.createTestimonial(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestimonialDTO> updateTestimonial(@PathVariable Long id,@RequestBody TestimonialDTO dto){
        return ResponseEntity.ok(testimonialService.updateTestimonial(id,dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id){
        testimonialService.deleteTestimonial(id);
        return ResponseEntity.noContent().build();
    }



}
