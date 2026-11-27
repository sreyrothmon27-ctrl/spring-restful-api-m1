package edu.kh.istad.springbootrestfullapi.service;

import edu.kh.istad.springbootrestfullapi.dto.UserCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // Delete user by id
    // return type
    // parameter type





public void deleteById(UUID id);


    UserResponse create(UserCreateRequest userCreateRequest);

    List<UserResponse>getAll();

    UserResponse getById(UUID id);




}
