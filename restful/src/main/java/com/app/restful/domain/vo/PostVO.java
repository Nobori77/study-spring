package com.app.restful.domain.vo;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;

    // 정적 팩토리 메서드
    static public PostVO from(PostUpdateRequestDTO postUpdateRequestDTO){
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postUpdateRequestDTO.getPostTitle());
        postVO.setPostContent(postUpdateRequestDTO.getPostContent());
        return postVO;
    }
    static public PostVO from(PostCreateRequestDTO postCreateRequestDTO){
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postCreateRequestDTO.getPostTitle());
        postVO.setPostContent(postCreateRequestDTO.getPostContent());
        return postVO;
    }
}
