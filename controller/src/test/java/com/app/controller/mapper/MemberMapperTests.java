package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void memberInsertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test888@gmail.com");
        memberVO.setMemberPassword("123123");
        memberVO.setMemberName("김영희");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectByMemberEmailAndMemberPassword(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test1234@gmail.com");
        memberVO.setMemberPassword("test1234");
        Optional<MemberVO> member = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("member : {}", member);
    }

    @Test
    public void deleteTest(){
        memberMapper.delete(24L);
    }
}
