package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.AuthorRequestDTO;
import com.personalprojects.MyBookstore.dto.AuthorResponseDTO;
import com.personalprojects.MyBookstore.model.Author;
import com.personalprojects.MyBookstore.model.Book;

import java.util.Collections;
import java.util.List;

public class AuthorMapper {
    public static AuthorResponseDTO toResponseDTO(Author author){
        if(author == null) return null;

        List<String> bookTitles = (author.getBooks() == null)
                ? Collections.emptyList()
                : author.getBooks().stream()
                    .map(Book::getTitle)
                    .toList();

        return AuthorResponseDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .bio(author.getBio())
                .countryName(author.getCountry() != null ? author.getCountry().getName() : null)
                .bookTitles(bookTitles)
                .build();
    }
}
