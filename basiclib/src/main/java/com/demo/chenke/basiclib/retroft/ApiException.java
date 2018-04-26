package com.demo.chenke.basiclib.retroft;

public class ApiException extends RuntimeException {

    private int code;


    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public ApiException(String message) {
        super(new Throwable(message));

    }
}