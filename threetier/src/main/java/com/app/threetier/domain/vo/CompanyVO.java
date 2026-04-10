package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyVO {
    Long id;
    String companyName;
    String getToWorkDateTime;
    String leaveToWorkDateTime;
}
