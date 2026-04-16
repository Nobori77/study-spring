package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @Parameter(
            name = "order",
            description = "게시글의 정렬을 처리하는 피라미터",
            schema = @Schema(type = "string"),
            required = true,
            in = ParameterIn.QUERY
    )
    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getPostList(
            @RequestParam(value = "order", defaultValue = "DESC") String order
    ) {
        // return postService.getPostList(order);
        List<PostDTO> postList = postService.getPostList(order);

        // .status 상태코드 -> mdn 상태코드
        // .body : 응답 데이터 -> ApiResponseDTO
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.of("게시글 목록 조회 성공", postList));
    }

    // 게시글 단일 조회 서비스
    @Operation(summary = "게시글 단일 조회 서비스", description = "해당 게시글 번호의 내용을 상세로 보여주는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"),
            required = true,
            in = ParameterIn.PATH
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getPostDetail(@PathVariable Long id) {
        PostDTO post = postService.getPostDetail(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("게시글 조회 성공", post));
    }

    // 게시글 작성 서비스
    @PostMapping("")
    @Operation(summary = "게시글 작성 서비스", description = "게시글 내용을 받아서 등록하는 서비스")
    @ApiResponse(responseCode = "201", description = "게시글 작성 성공")
    @ApiResponse(responseCode = "400", description = "잘못된 요청")
    public ResponseEntity<ApiResponseDTO> createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO) {
        // 필요하다면 service에서 생성된 게시글 정보를 반환받도록 변경 가능
        postService.createPost(postCreateRequestDTO, 1L);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseDTO.of("게시글 작성 성공"));
    }

    // 게시글 수정 서비스
    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정 서비스", description = "해당 번호의 게시글 내용을 받아서 수정하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 수정 완료")
    @ApiResponse(responseCode = "404", description = "게시글 수정 실패")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"),
            required = true,
            in = ParameterIn.PATH
    )
    public ResponseEntity<ApiResponseDTO> modifyPost(
            @RequestBody PostUpdateRequestDTO postUpdateRequestDTO,
            @PathVariable Long id
    ) {
        postService.modifyPost(postUpdateRequestDTO, id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("게시글 수정 성공"));
    }

    // 게시글 삭제 서비스
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제 서비스", description = "해당 번호로 게시글을 삭제하는 서비스")
    @ApiResponse(responseCode = "204", description = "게시글 삭제 성공")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"),
            required = true,
            in = ParameterIn.PATH
    )
    public ResponseEntity<ApiResponseDTO> removePost(@PathVariable Long id) {
        postService.remove(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(ApiResponseDTO.of("게시글 삭제 성공"));
    }
}