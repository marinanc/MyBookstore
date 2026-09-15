package com.personalprojects.MyBookstore.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDTO {
    private String title;
    private String isbnEbook;
    private String isbnPrint;
    private Integer publishedYear;
    private Integer pages;
    private String synopsis;
    private String linkDownload;
    private String version;
    private List<String> authorNames;
    private List<String> genreNames;
    private String publisherName;
    private String serieName;
    private String sourceName;
}
