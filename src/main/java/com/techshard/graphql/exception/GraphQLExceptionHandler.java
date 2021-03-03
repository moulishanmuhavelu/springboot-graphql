package com.techshard.graphql.exception;

import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLExceptionHandler {

    @ExceptionHandler
    public ThrowableGraphQLError handle(CustomRuntimeException e) {
        return new ThrowableGraphQLError(e);
    }
}
