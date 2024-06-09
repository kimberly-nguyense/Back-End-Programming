package com.example.demo.dao;

import com.example.demo.entities.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
