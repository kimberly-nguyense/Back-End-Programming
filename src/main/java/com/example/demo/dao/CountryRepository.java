package com.example.demo.dao;

import com.example.demo.entities.dto.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country, Long> {
}
