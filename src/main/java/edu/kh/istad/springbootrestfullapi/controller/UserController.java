package edu.kh.istad.springbootrestfullapi.controller;

import edu.kh.istad.springbootrestfullapi.dto.UserCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.UserRespone;
import edu.kh.istad.springbootrestfullapi.model.User;
import edu.kh.istad.springbootrestfullapi.repository.UserRepository;
import edu.kh.istad.springbootrestfullapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

   @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void deleteById(@PathVariable UUID id){
        userService.deleteById(id);
    }


   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping

    public UserRespone create(@RequestBody UserCreateRequest userCreateRequest) {
//        System.out.println("userCreateRequest: " + userCreateRequest);
       return userService.create(userCreateRequest);
    }


    @GetMapping

    public List<UserRespone>getAll() {
        return userService.getAll();

    }


}
