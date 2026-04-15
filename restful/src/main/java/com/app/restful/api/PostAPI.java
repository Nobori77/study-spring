package com.app.restful.api;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;

    // 게시글 목록 조회 서비스
    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @GetMapping("")
    public List<PostDTO> getPostList() {
        return postService.findAll();
    }

    // 게시글 단일 조회 서비스
    @Operation(summary = "게시글 단일 조회 서비스", description = "게시글을 조회해서 객체로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 단일 조회 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @GetMapping("/{id}")
    public PostDTO getPostInfo(@PathVariable Long id) {
        return postService.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }

    // 게시글 작성 서비스
    @PostMapping("")
    @Operation(summary = "게시글 작성 서비스", description = "게시글 정보를 받아서 등록하는 서비스")
    @ApiResponse(responseCode = "201", description = "게시글 작성 성공")
    public void write(@RequestBody PostDTO postDTO) {
        postService.insert(postDTO);
    }

    // 게시글 수정 서비스
    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정 서비스", description = "게시글 정보를 받아서 수정하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 수정 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public void updatePost(
            @RequestBody PostVO postVO,
            @PathVariable Long id) {
        postVO.setId(id);
        postService.update(postVO);
    }

    // 게시글 삭제 서비스
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제 서비스", description = "게시글 번호로 게시글을 삭제하는 서비스")
    @ApiResponse(responseCode = "204", description = "게시글 삭제 성공")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }
}