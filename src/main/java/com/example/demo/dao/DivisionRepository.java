package com.example.demo.dao;

import com.example.demo.entities.dto.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
