package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void getMember(){
        log.info("memberService : {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void insertMemberTest(){
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberEmail("test147@gmail.com");
        memberJoinRequestDTO.setMemberName("장길동");
        memberJoinRequestDTO.setMemberPassword("1234");
        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void updateMemberTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setId(1L);
        memberUpdateRequestDTO.setMemberName("hong길동");
        memberUpdateRequestDTO.setMemberPassword("123456789");
        memberService.updateMemberInfo(memberUpdateRequestDTO);
        log.info("memberUpdateRequestDTO : {}", memberUpdateRequestDTO);
    }

    @Test
    public void deleteMemberTest(){
        memberService.withdraw(24L);
    }
}
