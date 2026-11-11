package edu.kh.istad.springbootrestfullapi.exception;


import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity <ApiErrorRespone<?>> handle(ResponseStatusException e){
        ApiErrorRespone<?> body=ApiErrorRespone.builder()
                .code(e.getStatusCode().toString())
                .message(e.getReason())
                .build();
        return ResponseEntity.status(e.getStatusCode()).body(body);


    }

}
