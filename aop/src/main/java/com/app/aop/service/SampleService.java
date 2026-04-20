package com.app.aop.service;

import com.app.aop.aspect.annotation.LogStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Integer.*;

@Service
@Slf4j
public class SampleService {

    @LogStatus
    public int doAdd(String str1, String str2){
        log.info("핵심 로직");
        return parseInt(str1) + parseInt(str2);
    }
}
