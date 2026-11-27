package edu.kh.istad.springbootrestfullapi.repository;

import edu.kh.istad.springbootrestfullapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
