package com.emirhan.portfolio.content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentDTO {

    private Long id;

    private String key;

    private String value;

    private String contentType;
}
