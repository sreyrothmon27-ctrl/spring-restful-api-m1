package edu.kh.istad.springbootrestfullapi.dto;

import java.util.UUID;

public record UserRespone(
        UUID id,
        String fullname,
        Boolean isActive
) {


}
