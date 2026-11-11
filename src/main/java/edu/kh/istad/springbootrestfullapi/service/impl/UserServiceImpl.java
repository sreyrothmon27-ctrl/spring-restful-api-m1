package edu.kh.istad.springbootrestfullapi.service.impl;

import edu.kh.istad.springbootrestfullapi.dto.UserCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.UserRespone;
import edu.kh.istad.springbootrestfullapi.model.User;
import edu.kh.istad.springbootrestfullapi.repository.UserRepository;
import edu.kh.istad.springbootrestfullapi.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor


 public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void deleteById(UUID id){
        if (!userRepository.checkById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userRepository.deleteOne(id);
    }




    @Override
    public UserRespone create(UserCreateRequest userCreateRequest) {

        // 1.map data from dto to domain model

        User user=new User();
        user.setUsername(userCreateRequest.username());
        user.setPassword(userCreateRequest.password());
        user.setFullname(userCreateRequest.fullname());

        // 2. manage system data
        user.setId(UUID.randomUUID());
        user.setActive(true);

        // 3.save data
        userRepository.insertOne(user);

        //4.Map data from domain model to dto
        return new UserRespone(
                user.getId(),
                user.getFullname(),
                user.isActive()
        );

    }

    @Override
    public List<UserRespone> getAll() {
        return userRepository.selectAll()
                .stream()
                .map(user -> new UserRespone(
                        user.getId(),
                        user.getFullname(),
                        user.isActive()
                ))
                .toList();

    }

    @Override
    public User getById(UUID id) {
        return null;
    }
}