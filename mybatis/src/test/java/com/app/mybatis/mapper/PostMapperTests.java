package com.app.mybatis.mapper;

import com.app.mybatis.domain.dto.PostDTO;
import com.app.mybatis.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("오늘 점심 뭐 먹지?");
        postVO.setPostContent("아무거나");
        postVO.setMemberId(1L);
        postMapper.insert(postVO);
    }

    @Test
    public void selectAllTest(){
        postMapper.selectAll().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        Long postId = 3L;
        PostVO postVO = new PostVO();
        postVO.setId(postId);
        postVO.setPostReadCount(3L);
        postMapper.updatePostReadCount(3L);
        postMapper.select(postId).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void updateTest(){
        PostVO postVO = new PostVO();
        postVO.setId(2L);
        postVO.setPostTitle("오늘 점심은 배터지게 드세요!!");
        postVO.setPostContent("아무거나");
        postVO.setMemberId(1L);

        postMapper.update(postVO);
        postMapper.select(2L).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest(){
        postMapper.delete(2L);
    }

    @Test
    public void postUpdateReadCountTest(){
        PostVO postVO = new PostVO();
        postVO.setId(3L);
        postVO.setPostReadCount(3L);
        postMapper.updatePostReadCount(3L);
    }

    @Test
    public void postReadCountTest1(){
        postMapper.findByPostReadCount(3L).ifPresent(count -> log.info("조회수: {}", count));
    }




}
