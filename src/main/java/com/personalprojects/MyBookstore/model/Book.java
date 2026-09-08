package com.personalprojects.MyBookstore.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    private Long id;
    private String title;
    private String isbnEbook;
    private String isbnPrint;
    private Integer publishedYear;
    private Integer pages;
    private String synopsis;
    private String linkDownload;
    private String version;
    private List<Author> authors;
    private List<Genre> genres;
    private Publisher publisher;
    private Serie serie;
    private Source source;
}
