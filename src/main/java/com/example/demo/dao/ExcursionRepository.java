package com.example.demo.dao;


import com.example.demo.entities.dto.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
