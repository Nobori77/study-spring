package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsUtillTests {
    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void smsTest(){
        smsUtil.sendOneMemberPhone("01056038560", "개발자가 좋아하는 계절은? Spring ㅎㅎ");
    }

    @Test
    public void mailTest(){
        smsUtil.sendMemberEmail("minginew77@gmail.com", "테스트", "테스트");
    }
}
