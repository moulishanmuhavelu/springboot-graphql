package com.techshard.graphql.exception;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(String message) {
        super(message);
    }

    public CustomRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
