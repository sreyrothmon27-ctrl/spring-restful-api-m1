package edu.kh.istad.springbootrestfullapi.repository;

import edu.kh.istad.springbootrestfullapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
