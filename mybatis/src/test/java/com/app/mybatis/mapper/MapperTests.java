package com.app.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void MapperTests() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void MapperTests2() {
        log.info(timeMapper.getTime2());
    }

    @Test
    public void MemberMapper(){
        log.info(memberMapper.selectAll().toString());
    }
}
