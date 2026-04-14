package com.app.restful.exception;

public class MemberException extends RuntimeException {
    public MemberException(){;}
    public MemberException(String message){
        super(message);
    }
}
