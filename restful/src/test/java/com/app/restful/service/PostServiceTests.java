package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {
    @Autowired
    private PostService postService;

    @Test
    public void getPostListTest(){
        log.info("postService : {}", postService.getPostList("oldest"));
    }

    @Test
    public void getPostDetailTest(){
        log.info("postService : {}", postService.getPostDetail(1L));
    }

    @Test
    public void createPostTest(){
        PostCreateRequestDTO postCreateRequestDTO = new PostCreateRequestDTO();
        postCreateRequestDTO.setPostTitle("테테스스트트");
        postCreateRequestDTO.setPostContent("테테스스스스트트트");
        postService.createPost(postCreateRequestDTO, 1L);
        log.info("postService : {}", postService.getPostList("desc"));
    }

    @Test
    public void modifyPostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setPostTitle("테테스스스트트트");
        postUpdateRequestDTO.setPostContent("테테스스트트트트");
        postService.modifyPost(postUpdateRequestDTO, 1L);
        log.info("postService : {}", postService.getPostList("desc"));
    }

    @Test
    public void removePostTest(){
        postService.remove(1L);
        log.info("postService : {}", postService.getPostList("desc"));
    }

    @Test
    public void removeByMemberIdTest(){
        postService.removeByMemberId(1L);
    }
}
