package com.personalprojects.MyBookstore.dto;

import lombok.*;

import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String isbnEbook;
    private String isbnPrint;
    private Integer publishedYear;
    private Integer pages;
    private String synopsis;
    private String linkDownload;
    private String version;
    private Set<AuthorDTO> authors;
    private Set<GenreDTO> genres;
    private Long idPublisher;
    private Long idSerie;
    private Long idSource;
}
