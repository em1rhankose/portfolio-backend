package com.emirhan.portfolio.testimonial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="testimonials")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column
    private String companyOrPosition;

    @Column
    private String photoUrl;

    @Column(nullable = false)
    private boolean visible;

}
