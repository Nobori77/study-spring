package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "회원 정보")
public class MemberResponseDTO {
    @Schema(description = "회원 번호", required = true, example = "1")
    private Long id;
    @Schema(description = "회원 이메일", required = true, example = "test123@gmail.com")
    private String memberEmail;
    @Schema(description = "회원 이름", example = "홍길동")
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
