package com.app.ncs.mapper;

import com.app.ncs.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest

public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test234@gmail.com");
        memberVO.setMemberPassword("123123");
        memberVO.setMemberName("장보고");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectByMemberEmailAndMemberPassword(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("123123");
        Optional<MemberVO> member = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("member : {}", member);
    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test23456@gmail.com");
        memberVO.setMemberPassword("123456789");
        memberVO.setMemberName("장장보고보고");
        memberVO.setId(2L);
        memberMapper.update(memberVO);
        log.info("member : {}", memberVO);
    }

    @Test
    public void deleteTest(){
        memberMapper.delete(4L);
    }
}
