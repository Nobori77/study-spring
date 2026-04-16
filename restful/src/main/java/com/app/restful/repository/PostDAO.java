package com.app.restful.repository;


import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.MemberMapper;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    //게시판 관련 서비스
//- 게시글 목록 조회 서비스
    public List<PostDTO> getPosts(Map<String, String> orders){
        return postMapper.selectAll(orders);
    }
//- 게시글 상세보기 조회 서비스
    public Optional<PostDTO> getPost(Long id){
        return Optional.ofNullable(postMapper.select(id));
    }
//- 게시글 작성 서비스
    public void save(PostVO postVO){
        postMapper.insert(postVO);
    }
//- 게시글 수정 서비스
    public void update(PostVO postVO){
         postMapper.update(postVO);
    }
//- 게시글 삭제 서비스
    public void delete(Long id){
        postMapper.delete(id);
    }
//- 게시글 삭제(탈퇴시) 서비스
    public void deleteByMemberId(Long memberId){
        postMapper.deleteByMemberId(memberId);
    }
}
