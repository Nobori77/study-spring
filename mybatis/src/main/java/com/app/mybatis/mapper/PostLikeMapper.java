package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.PostLikeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostLikeMapper {
    public void insert(PostLikeVO postLikeVO);
    public void delete(Long id);
}
