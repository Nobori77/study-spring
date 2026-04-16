package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public List<PostDTO> getPostList(String order) {
        Map<String, String> orders = new HashMap<>();
        orders.put("order", order);
        return postDAO.getPosts(orders);
    }

    @Override
    public PostDTO getPostDetail(Long id) {
        return postDAO.getPost(id).orElseThrow(() -> { throw new PostException("게시글을 찾을수 없습니다", HttpStatus.NOT_FOUND);});
    }

    @Override
    public void createPost(PostCreateRequestDTO postCreateRequestDTO, Long memberId) {
        PostVO postVO = PostVO.from(postCreateRequestDTO);
        postVO.setMemberId(memberId);
        postDAO.save(postVO);
    }

    @Override
    public void modifyPost(PostUpdateRequestDTO postUpdateRequestDTO, Long id) {
        PostVO postVO = PostVO.from(postUpdateRequestDTO);
        postVO.setId(id);
        postDAO.update(postVO);
    }

    @Override
    public void remove(Long id) {
        postDAO.delete(id);
    }

    @Override
    public void removeByMemberId(Long memberId) {
        postDAO.deleteByMemberId(memberId);
    }
}
