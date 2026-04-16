package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface PostMapper {
    // 게시글 전체 조회 + 정렬
    public List<PostDTO> selectAll(Map<String, String> orders);
    // 게시글 단일 조회
    public PostDTO select(Long id);
    // 게시글 추가
    public void insert(PostVO postVO);
    // 게시글 수정
    public void update(PostVO postVO);
    // 게시글 삭제
    public void delete(Long id);
    // 회원 탈퇴 시 게시글 삭제
    public void deleteByMemberId(Long id);
}