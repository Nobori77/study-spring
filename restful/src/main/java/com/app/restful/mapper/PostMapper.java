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
    public void insert(PostDTO postDTO);
    public PostVO update(PostVO postVO);
    public void delete(Long id);
    public void deleteAll(Long id);
}