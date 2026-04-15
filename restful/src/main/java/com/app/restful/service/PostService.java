package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시판 관련 서비스
//- 게시글 목록 조회 서비스
    public List<PostDTO> findAll();
//- 게시글 상세보기 조회 서비스
    public Optional<PostDTO> findById(Long id);
//- 게시글 작성 서비스
    public void insert(PostDTO postDTO);
//- 게시글 수정 서비스
    public void update(PostVO postVO);
//- 게시글 삭제 서비스
    public void delete(Long id);
//- 게시글 삭제(탈퇴시) 서비스
    public void deleteAll(Long id);
}
