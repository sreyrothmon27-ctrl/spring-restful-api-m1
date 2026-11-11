package edu.kh.istad.springbootrestfullapi.dto;

public record UserCreateRequest(

        String username,
        String password,
        String fullname


) {
}
