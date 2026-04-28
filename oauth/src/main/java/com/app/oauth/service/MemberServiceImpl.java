package com.app.oauth.service;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.domain.dto.JwtTokenDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.dto.response.MemberResponseDTO;
import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.domain.vo.SocialMemberVO;
import com.app.oauth.exception.MemberException;
import com.app.oauth.repository.MemberDAO;
import com.app.oauth.repository.SocialMemberDAO;
import com.app.oauth.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {Exception.class})
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final SocialMemberDAO socialMemberDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    // 회원 가입 서비스
    @Override
    public ApiResponseDTO join(MemberDTO memberDTO) {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        Map<String, Object> claims = new HashMap<>();

        // 1. 중복 여부 검사
        // 중복된 값이 있으면 throw
        if(memberDAO.existsMemberByMemberEmail(memberDTO)){
            throw new MemberException("중복된 이메일 입니다.", HttpStatus.BAD_REQUEST);
        }
        // 중복된 값이 없으면 서비스 처리
        // 2. 비밀번호 암호화(단방향)
        // 소셜 회원가입시 비밀번호가 없음
        // 로컬 회원기입만 비밀번호를 가지고 있음
        MemberVO memberVO = MemberVO.from(memberDTO);
        SocialMemberVO socialMemberVO = SocialMemberVO.from(memberDTO);

//        socialMemberVO.getSocialMemberProvider().equals("local")
//        윗 코드보다 아래 코드가 좋음 -> 문자열에 .equals는 null값이 안 들어가기 때문에
//        null값일 경우 false가 반환됨
        if("local".equals(socialMemberVO.getSocialMemberProvider())){
            memberVO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        }

        // save -> selectkey id -> vo -> 방금 회원가입 된 id
        memberDAO.save(memberVO);
        socialMemberVO.setMemberId(memberVO.getId());

        // 3. DB에 회원 추가
        // DTO -> MemberVO
        // DTO -> SocialMemberVO
        // insert 처리 (트랜잭션관리) throw
        socialMemberDAO.save(socialMemberVO);

        // 4. 커스텀 Exception 처리
        // 5. 리턴 여부 확인
        claims.put("id", memberVO.getId());
        claims.put("memberEmail", memberVO.getMemberEmail());
        claims.put("memberProvider", socialMemberVO.getSocialMemberProvider());

        apiResponseDTO.setSuccess(true);
        apiResponseDTO.setMessage("회원가입이 완료되었습니다");
        apiResponseDTO.setData(claims);
        // 회원 가입 후 로그인 페이지 -> 메세지 반환
        return apiResponseDTO;
    }


    @Override
    public ApiResponseDTO me(String token) {
        Claims claims = jwtTokenUtil.parseToken(token);
        Long id = Long.parseLong(claims.get("id").toString());

        MemberDTO foundMember = memberDAO.findMemberById(id).orElseThrow(() -> {
            throw new MemberException("회원 조회 실패" , HttpStatus.BAD_REQUEST);
        });

        MemberResponseDTO memberResponseDTO = MemberResponseDTO.from(foundMember);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "회원 조회 성공", memberResponseDTO);

        return apiResponseDTO;
    }
}

