package com.personalprojects.MyBookstore.repository;

import com.personalprojects.MyBookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameIgnoreCase(String name);
    // "LIKE %name%"
    List<Author> findByNameContainingIgnoreCase(String name);
}
