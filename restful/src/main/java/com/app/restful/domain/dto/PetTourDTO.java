package com.app.restful.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PetTourDTO {
    private String areacode;
    private String title;
    private String contentid;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String firstimage;
    private String firstimage2;
    private String tel;
}
