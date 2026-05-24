package com.emirhan.portfolio.testimonial;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestimonialDTO {

    private Long id;

    private String clientName;

    private String comment;

    private String companyOrPosition;

    private String photoUrl;

    private boolean visible;

}
