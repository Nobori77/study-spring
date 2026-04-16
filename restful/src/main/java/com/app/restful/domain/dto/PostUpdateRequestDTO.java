package com.app.restful.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "게시글 수정 DTO")
public class PostUpdateRequestDTO {
    @Schema(description = "게시글 제목", example = "수정된 게시글 제목", required = true)
    private String postTitle;
    @Schema(description = "게시글 내용", example = "수정된 게시글 내용", required = true)
    private String postContent;
}
