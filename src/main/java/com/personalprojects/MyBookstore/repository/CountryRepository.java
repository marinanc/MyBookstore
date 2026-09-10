package com.personalprojects.MyBookstore.repository;

import com.personalprojects.MyBookstore.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
