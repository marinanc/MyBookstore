package com.personalprojects.MyBookstore.repository;

import com.personalprojects.MyBookstore.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
