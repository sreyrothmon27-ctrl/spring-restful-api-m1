package edu.kh.istad.springbootrestfullapi.dto;

import lombok.Builder;

@Builder
public record CategoryResposne(
        Integer id,
        String name,
        String icon
) {
}