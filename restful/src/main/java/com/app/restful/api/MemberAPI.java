package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    // 회원 목록 조회 서비스
    @Operation(summary = "회원 목록 조회 서비스", description = "회원 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 조회 실패")
    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getMemberList() {
        List<MemberResponseDTO> memberList = memberService.getMemberInfoList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("회원 목록 조회 성공", memberList));
    }

    // 회원 정보 조회 서비스
    @Operation(summary = "회원 단일 조회 서비스", description = "회원 조회해서 객체로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 조회 실패")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getMemberInfo(@PathVariable Long id) {
        MemberResponseDTO member = memberService.getMemberInfo(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("회원 조회 성공", member));
    }

    // 회원 추가 서비스
    @PostMapping("/join")
    @Operation(summary = "회원가입 서비스", description = "회원 정보를 받아서 회원가입을 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    @ApiResponse(responseCode = "409", description = "이메일 중복")
    public ResponseEntity<ApiResponseDTO> join(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO) {
        memberService.join(memberJoinRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseDTO.of("회원가입 성공"));
    }

    // 로그인
    @PostMapping("/login")
    @Operation(summary = "로그인 서비스", description = "이메일과 비밀번호를 검증 후 로그인 서비스")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    @ApiResponse(responseCode = "401", description = "로그인 실패")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody MemberVO memberVO) {
        MemberResponseDTO loginMember = memberService.login(memberVO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("로그인 성공", loginMember));
    }

    // 회원 정보 수정 서비스
    @PutMapping("/{id}")
    @Operation(summary = "회원정보수정 서비스", description = "회원 정보를 받아서 수정시켜주는 서비스")
    @ApiResponse(responseCode = "200", description = "회원정보수정 성공")
    @ApiResponse(responseCode = "400", description = "잘못된 접근")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> updateMemberInfo(
            @RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO,
            @PathVariable Long id
    ) {
        memberUpdateRequestDTO.setId(id);
        memberService.updateMemberInfo(memberUpdateRequestDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("회원정보수정 성공"));
    }

    // 회원 탈퇴 서비스
    @DeleteMapping("/{id}")
    @Operation(summary = "회원탈퇴 서비스", description = "회원 아이디로 회원탈퇴를 시켜주는 서비스")
    @ApiResponse(responseCode = "204", description = "회원탈퇴 성공")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> withdraw(@PathVariable Long id) {
        memberService.withdraw(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(ApiResponseDTO.of("회원탈퇴 성공"));
    }
}