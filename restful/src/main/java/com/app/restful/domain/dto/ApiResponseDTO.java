package com.app.restful.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Schema(description = "서버 응답 DTO")
public class ApiResponseDTO<T> {
    @Schema(description = "응답 메세지", example = "조회 성공", required = true)
    private String message;
    @Schema(description = "응답 데이터")
    private T data;

    public static<T> ApiResponseDTO of(String message){
        return new ApiResponseDTO<>(message, null);
    }

    public static<T> ApiResponseDTO<T> of(String message, T data){
        return new ApiResponseDTO<>(message, data);
    }


}