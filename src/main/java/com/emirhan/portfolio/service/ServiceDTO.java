package com.emirhan.portfolio.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {

    private Long id;

    private String title;

    private String description;

    private String icon;

    private int orderIndex;

    private boolean visible;

}
