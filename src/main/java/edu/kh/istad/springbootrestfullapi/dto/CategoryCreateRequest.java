package edu.kh.istad.springbootrestfullapi.dto;

public record CategoryCreateRequest<icon>(
        String name,
        String icon

) {

}
