package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.BookResponseDTO;
import com.personalprojects.MyBookstore.model.Author;
import com.personalprojects.MyBookstore.model.Book;
import com.personalprojects.MyBookstore.model.Genre;

import java.util.Collections;
import java.util.List;

public class BookMapper {
    public static BookResponseDTO toResponseDTO (Book book){
        if(book == null) return null;

        List<String> authorNames = (book.getAuthors() == null)
                ? Collections.emptyList()
                : book.getAuthors().stream()
                    .map(Author::getName)
                    .toList();

        List<String> genreNames = (book.getGenres() == null)
                ? Collections.emptyList()
                : book.getGenres().stream()
                    .map(Genre::getName)
                    .toList();

        return BookResponseDTO.builder()
                .title(book.getTitle())
                .isbnEbook(book.getIsbnEbook())
                .isbnPrint(book.getIsbnPrint())
                .publishedYear(book.getPublishedYear())
                .pages(book.getPages())
                .synopsis(book.getSynopsis())
                .linkDownload(book.getLinkDownload())
                .version(book.getVersion())
                .authorNames(authorNames)
                .genreNames(genreNames)
                .publisherName(book.getPublisher() != null ? book.getPublisher().getName() : null)
                .serieName(book.getSerie() != null ? book.getSerie().getName() : null)
                .sourceName(book.getSource() != null ? book.getSource().getName() : null)
                .build();
    }
}
