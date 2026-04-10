package com.app.restful.repository;

import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    // 회원 추가
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    // 회원 단일 조회(id)
    public MemberVO findById(Long id){
        return memberMapper.selectById(id);
    }

    public List<MemberVO> findAll(){
        return memberMapper.selectAll();
    }
    // 회원 단일 조회(Email, Password)
    public MemberVO findByEmailAndPassword(MemberVO memberVO){
        return memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
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
