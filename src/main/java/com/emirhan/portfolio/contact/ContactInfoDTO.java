package com.emirhan.portfolio.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDTO {

    private Long id;

    private String platform;

    private String url;

    private String icon;

    private boolean visible;

}
