package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.exception.MemberException;
import com.app.restful.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberJoinRequestDTO memberJoinRequestDTO) {
        // 이메일 중복 여부 확인
        // 회원 정보 추가 할 수 있도록 코드 리팩토링
        this.checkMemberEmailDuplicate(memberJoinRequestDTO.getMemberEmail());
        // 서비스 단에서 DTO -> VO 옮겨담는다
        memberDAO.save(MemberVO.from(memberJoinRequestDTO));
    }

    @Override
    public void checkMemberEmailDuplicate(String memberEmail) {
        if(memberDAO.existMemberEmail(memberEmail) > 0){
            throw new MemberException("이메일이 존재합니다.");
        }
    }

    @Override
    public List<MemberResponseDTO> getMemberInfoList() {
        return memberDAO.findAll().stream().map(MemberResponseDTO::from).toList();
    }
    // 로그인 서비스
    // 아이디 또는 비밀번호가 일치하지 않으면 throw
    // 화면에 비밀번호X -> ResponseDTO
    // 아이디와 비밀번호가 일치하는 회원정보를 화면으로 응답

    // 정석은 throw를 service에서 던짐
    // Optional이 없는 상태로 리턴해야함
    @Override
    public MemberResponseDTO login(MemberVO memberVO) {
//        return Optional.ofNullable(MemberResponseDTO.from(memberDAO.findByEmailAndPassword(memberVO)));

//        return Optional
//                .ofNullable(memberDAO.findByEmailAndPassword(memberVO))
//                .map(MemberResponseDTO::from);
       return memberDAO.findByEmailAndPassword(memberVO)
                .map(MemberResponseDTO::from)
                .orElseThrow(() -> {
                    throw new MemberException("아이디 또는 비밀번호를 확인하세요");
                });
    }

    // 회원 정보 조회
    @Override
    public MemberResponseDTO getMemberInfo(Long id) {
//        회원의 비밀번호를 제거 후 화면에 출력
        return memberDAO.findById(id)
                .map(MemberResponseDTO::from)
                .orElseThrow(() -> { throw new MemberException("회원을 찾을수 없습니다");});
    }

    // 회원정보 수정
    @Override
    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        memberDAO.update(MemberVO.from(memberUpdateRequestDTO));
    }

    // 회원 탈퇴
    @Override
    public void withdraw(Long id) {
        //  참조하는 POST 게시판의 삭제
        memberDAO.delete(id);
    }
}
