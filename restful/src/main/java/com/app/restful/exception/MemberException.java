package com.app.restful.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MemberException extends RuntimeException {
    // 에러 핸들링 분기 처리를 위한 목적
    private HttpStatus status;

    public MemberException(){;}
    public MemberException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
