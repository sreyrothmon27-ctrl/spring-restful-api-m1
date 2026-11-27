package edu.kh.istad.springbootrestfullapi.init;

import edu.kh.istad.springbootrestfullapi.model.User;
import edu.kh.istad.springbootrestfullapi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DataInitialization {
    private final UserRepository userRepository;

    @PostConstruct
    void init() {
            if (userRepository.count() == 0) {
                    // insert userninto table posgres
                    // 1. create  entity objecct
                    User user = new User();
                    user.setFullname("Adminstation");
                    user.setUsername("admin");
                    user.setPassword("qwer");
                    user.setIsActive(true);


                    User user2 = new User();
                    user2.setFullname("Edditer");
                    user2.setUsername("editer");
                    user2.setPassword("qwer");
                    user2.setIsActive(true);

                    User user3 = new User();
                    user3.setFullname("Monsreyroth");
                    user3.setUsername("monsreyroth");
                    user3.setPassword("qwer");
                    user3.setIsActive(false);

                    userRepository.save(user);
                    userRepository.save(user2);
                    userRepository.save(user3);
            }
    }
}

