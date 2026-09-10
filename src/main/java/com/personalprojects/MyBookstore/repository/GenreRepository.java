package com.personalprojects.MyBookstore.repository;

import com.personalprojects.MyBookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
