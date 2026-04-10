package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberResponseDTO {
    private Long id;
    private String memberEmail;
    private String memberName;

//    정적 팩토리 메서드
    public static MemberResponseDTO from(MemberVO memberVO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        return memberResponseDTO;
    }
}
