package com.emirhan.portfolio.workprocess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkProcessDTO {

    private Long id;

    private int stepNumber;

    private String title;

    private String description;

    private boolean visible;



}
