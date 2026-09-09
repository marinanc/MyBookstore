package com.personalprojects.MyBookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String isbnEbook;
    private String isbnPrint;
    private Integer publishedYear;
    private Integer pages;
    @Column(columnDefinition = "TEXT")
    private String synopsis;
    private String linkDownload;
    private String version;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();
    @ManyToMany
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Serie serie;
    @ManyToOne
    private Source source;
}
