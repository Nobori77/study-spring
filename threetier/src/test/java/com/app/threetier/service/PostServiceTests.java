package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {
    @Autowired
    private PostService postService;
    @Autowired
    private PostVO postVO;

    @Test
    void getPostTest() {
        log.info("post: {}", postService.getPost(1L));
    }

    @Test
    void updateTest(){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle("test");
        postDTO.setPostContent("test");
        postDTO.setId(1L);
        postService.update(postVO);
    }

    @Test
    public void deletePostsTest(){
        postService.delete(3L);
    }
}
