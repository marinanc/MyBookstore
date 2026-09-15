package com.personalprojects.MyBookstore.dto;

import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDTO {
    private String title;
    private String isbnEbook;
    private String isbnPrint;
    private Integer publishedYear;
    private Integer pages;
    private String synopsis;
    private String linkDownload;
    private String version;
    private Set<Long> authorIds;
    private Set<Long> genreIds;
    private Long idPublisher;
    private Long idSerie;
    private Long idSource;
}
