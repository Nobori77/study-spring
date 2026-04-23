package com.app.oauth.mapper;

import com.app.oauth.domain.vo.SocialMemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SocialMemberMapper {
    public void insert(SocialMemberVO socialMemberVO);
}
