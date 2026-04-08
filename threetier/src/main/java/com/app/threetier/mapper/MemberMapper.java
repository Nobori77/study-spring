package com.app.threetier.mapper;

import com.app.threetier.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Long id);
}
