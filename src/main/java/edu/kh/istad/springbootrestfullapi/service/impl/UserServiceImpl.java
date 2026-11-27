package edu.kh.istad.springbootrestfullapi.service.impl;

import edu.kh.istad.springbootrestfullapi.dto.UserCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.UserResponse;
import edu.kh.istad.springbootrestfullapi.model.User;
import edu.kh.istad.springbootrestfullapi.repository.UserRepository;
import edu.kh.istad.springbootrestfullapi.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void deleteById(UUID id) {

    }


    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user=new User();
        user.setFullname(userCreateRequest.fullname());
        user.setUsername(userCreateRequest.username());
        user.setPassword(userCreateRequest.password());
        user.setIsActive(true);

       User savedUser = userRepository.save(user);
        log.info("After saving user: {} ",user.getId());


        return UserResponse.builder()
                .id(savedUser.getId())
                .fullname(savedUser.getFullname())
                .isActive(savedUser.getIsActive())
                .build();
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .fullname(user.getFullname())
                        .isActive(user.getIsActive())
                        .build())
                .toList() ;

    }

    @Override
    public UserResponse getById(UUID id){
        return userRepository.findById(id)
                .map(user ->  UserResponse.builder()
                        .id(user.getId())
                        .fullname(user.getFullname())
                        .isActive(user.getIsActive())
                        .build())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
    }}

