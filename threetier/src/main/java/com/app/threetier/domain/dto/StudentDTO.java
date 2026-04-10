package com.app.threetier.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class StudentDTO {
    private Long id;
    private String studentName;
    private Integer kor;
    private Integer eng;
    private Integer math;
    private Integer total;
    private Double average;
}
