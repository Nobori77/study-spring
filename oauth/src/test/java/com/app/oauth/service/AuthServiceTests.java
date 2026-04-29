package com.app.oauth.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AuthServiceTests {
    @Autowired
    private AuthService authService;

    @Test
    public void sendMemberPhoneCodeTest(){
        authService.sendMemberPhoneVerificationCode("01076016123");
    }

    @Test
    public void verifyMemberPhoneCodeTest(){
        log.info("{}", authService.verifyMemberPhoneVerificationCode("01076016123", "197878"));
    }

    @Test
    public void sendMemberEmailCodeTest(){
        authService.sendMemberEmailVerificationCode("minginew77@gmail.com");
    }

    @Test
    public void verifyMemberEmailCodeTest(){
        log.info("{}", authService.verifyMemberEmailVerificationCode("minginew77@gmail.com", "191744"));
    }
}
