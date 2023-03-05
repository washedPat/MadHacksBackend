package com.madhacks.backend.common;

public class ErrorResponse {
    private String msg;
    public ErrorResponse(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }
}
