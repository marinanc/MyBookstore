package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.AuthorDTO;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO> getAuthors();
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);
    void deleteAuthor(Long id);
}
