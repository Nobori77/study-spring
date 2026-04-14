package com.app.restful.domain.vo;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    // 정적 팩토리 메서드
    static public MemberVO from (MemberJoinRequestDTO memberJoinRequestDTO){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }

    static public MemberVO from (MemberUpdateRequestDTO memberUpdateRequestDTO){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberUpdateRequestDTO.getId());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        return memberVO;
    }
}
