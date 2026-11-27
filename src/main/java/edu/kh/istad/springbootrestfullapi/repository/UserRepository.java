package edu.kh.istad.springbootrestfullapi.repository;

import edu.kh.istad.springbootrestfullapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository

public interface UserRepository extends JpaRepository<User,UUID> {

}


