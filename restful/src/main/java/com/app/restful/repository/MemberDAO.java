package com.app.restful.repository;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Optional 처리 == 공식


@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    // 회원 추가
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    // 이메일 유무 검사
    public int existMemberEmail(String memberEmail){
        return memberMapper.existMemberEmail(memberEmail);
    }

    // 회원 단일 조회(id)
    public Optional<MemberVO> findById(Long id){
        return Optional.ofNullable(memberMapper.selectById(id));
    }

    // 회원 전체 조회
    public List<MemberVO> findAll(){
        return memberMapper.selectAll();
    }

    // 회원 단일 조회(Email, Password)
    public Optional<MemberVO> findByEmailAndPassword(MemberVO memberVO){
        return Optional.ofNullable(memberMapper.selectByMemberEmailAndMemberPassword(memberVO));
    }

    // 회원 수정
    public void update(MemberVO memberVO){
        memberMapper.update(memberVO);
    }

    // 회원 삭제
    public void delete(Long id){
        memberMapper.delete(id);
    }
}
