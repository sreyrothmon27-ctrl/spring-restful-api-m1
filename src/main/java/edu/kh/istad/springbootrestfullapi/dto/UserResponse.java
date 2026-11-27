package edu.kh.istad.springbootrestfullapi.dto;

import lombok.Builder;

import java.util.UUID;
@Builder
public record UserRespone(
        UUID id,
        String fullname,
        Boolean isActive
) {


}
