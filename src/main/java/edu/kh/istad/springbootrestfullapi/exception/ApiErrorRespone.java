package edu.kh.istad.springbootrestfullapi.exception;

import lombok.Builder;

@Builder
public record ApiErrorRespone<T>(
        String message,
        String code,
        T data

) {
}
