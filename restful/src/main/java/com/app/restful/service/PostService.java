package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시판 관련 서비스
//- 게시글 목록 조회 서비스
    public List<PostDTO> getPostList(String order);
//- 게시글 상세보기 조회 서비스
    public PostDTO getPostDetail(Long id);
//- 게시글 작성 서비스
    public void createPost(PostCreateRequestDTO postCreateRequestDTO, Long memberId);
    //- 게시글 수정 서비스
    public void modifyPost(PostUpdateRequestDTO postUpdateRequestDTO, Long id);
//- 게시글 삭제 서비스
    public void remove(Long id);
//- 게시글 삭제(탈퇴시) 서비스
    public void removeByMemberId(Long id);
}
