package com.app.oauth.domain.vo;

import com.app.oauth.domain.dto.MemberDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberPicture;
    private String memberName;
    private String memberNickname;


    public static MemberVO from(MemberDTO memberDTO){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberDTO.getMemberId());
        memberVO.setMemberEmail(memberDTO.getMemberEmail());
        memberVO.setMemberPassword(memberDTO.getMemberPassword());
        memberVO.setMemberPicture(memberDTO.getMemberPicture() != null ? memberDTO.getMemberPicture() : "https://testapp-codefuling.s3.ap-northeast-2.amazonaws.com/cat.jpg");
        memberVO.setMemberName(memberDTO.getMemberName());
        memberVO.setMemberNickname(memberDTO.getMemberNickname() != null ? memberDTO.getMemberNickname() : "개복치 1단계");
        return memberVO;
    }
}
