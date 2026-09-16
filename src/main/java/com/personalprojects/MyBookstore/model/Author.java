package com.personalprojects.MyBookstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String bio;

    @ManyToOne
    private Country country;

    // Mapped by Book model
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
