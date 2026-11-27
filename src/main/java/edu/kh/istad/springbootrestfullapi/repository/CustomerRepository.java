package edu.kh.istad.springbootrestfullapi.repository;

import edu.kh.istad.springbootrestfullapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
