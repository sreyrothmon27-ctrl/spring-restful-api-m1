package edu.kh.istad.springbootrestfullapi.service;

import edu.kh.istad.springbootrestfullapi.dto.UserCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.UserRespone;
import edu.kh.istad.springbootrestfullapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // Delete user by id
    // return type
    // parameter type





public void deleteById(UUID id);


    UserRespone create(UserCreateRequest userCreateRequest);

    List<UserRespone>getAll();

    User getById(UUID id);

}
