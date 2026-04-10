package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public List<PostDTO> selectAll();
    public Optional<PostDTO> select(Long id);
    public PostVO update(PostVO postVO);
    public void updateReadCount(Long id);
    public void delete(Long id);
}