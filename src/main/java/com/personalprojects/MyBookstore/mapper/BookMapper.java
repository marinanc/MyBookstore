package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.BookRequestDTO;
import com.personalprojects.MyBookstore.dto.BookResponseDTO;
import com.personalprojects.MyBookstore.model.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
                .id(book.getId())
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
                .bookCover(book.getBookCover())
                .publisherName(book.getPublisher() != null ? book.getPublisher().getName() : null)
                .serieName(book.getSerie() != null ? book.getSerie().getName() : null)
                .sourceName(book.getSource() != null ? book.getSource().getName() : null)
                .build();
    }

    public static Book toEntity(BookRequestDTO bookReqDTO,
                                Set<Author> bookAuthors,
                                Set<Genre> bookGenres,
                                Publisher bookPublisher,
                                Serie bookSerie,
                                Source bookSource) {
        if(bookReqDTO == null) return null;

        return Book.builder()
                .title(bookReqDTO.getTitle())
                .isbnEbook(bookReqDTO.getIsbnEbook())
                .isbnPrint(bookReqDTO.getIsbnPrint())
                .publishedYear(bookReqDTO.getPublishedYear())
                .pages(bookReqDTO.getPages())
                .synopsis(bookReqDTO.getSynopsis())
                .linkDownload(bookReqDTO.getLinkDownload())
                .version(bookReqDTO.getVersion())
                .bookCover(bookReqDTO.getBookCover())
                .authors(bookAuthors)
                .genres(bookGenres)
                .publisher(bookPublisher)
                .serie(bookSerie)
                .source(bookSource)
                .build();
    }
}
