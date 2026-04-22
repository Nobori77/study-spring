package com.app.oauth.mapper;

import com.app.oauth.domain.vo.OauthMemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    // 회원추가
    public void insert(OauthMemberVO oauthMemberVO);
    // 회원 이메일 유무 조회
    public int existMemberEmail(String memberEmail);
    // 회원 전체 조회
    public List<OauthMemberVO> selectAll();
    // 회원 단일 조회(id)
    public OauthMemberVO selectById(Long id);
    // 회원 단일 조회 (Email, Password)
    public OauthMemberVO selectByMemberEmailAndMemberPassword(OauthMemberVO oauthMemberVO);
    // 회원 수정
    public void update(OauthMemberVO oauthMemberVO);
    // 회원 삭제
    public void delete(Long id);
}
