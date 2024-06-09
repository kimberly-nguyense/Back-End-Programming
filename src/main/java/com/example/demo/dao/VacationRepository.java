package com.example.demo.dao;

import com.example.demo.entities.dto.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
