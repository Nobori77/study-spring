package com.app.mybatis.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private Long memberId;
    private String memberName;
    private String memberPassword;
    private String memberEmail;
    private Long postLikeCount;
    private Boolean isLiked;
}
