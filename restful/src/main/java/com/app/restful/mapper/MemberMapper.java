package com.app.restful.mapper;

import com.app.restful.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    // 회원추가
    public void insert(MemberVO memberVO);
    // 회원 전체 조회
    public List<MemberVO> selectAll();
    // 회원 단일 조회(id)
    public MemberVO selectById(Long id);
    // 회원 단일 조회 (Email, Password)
    public MemberVO selectByMemberEmailAndMemberPassword(MemberVO memberVO);
    // 회원 수정
    public void update(MemberVO memberVO);
    // 회원 삭제
    public void delete(Long id);
}
