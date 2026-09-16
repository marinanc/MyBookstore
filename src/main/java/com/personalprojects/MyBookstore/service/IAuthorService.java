package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.AuthorDTO;
import com.personalprojects.MyBookstore.dto.AuthorRequestDTO;
import com.personalprojects.MyBookstore.dto.AuthorResponseDTO;

import java.util.List;

public interface IAuthorService {
    List<AuthorResponseDTO> getAuthors();
    AuthorResponseDTO createAuthor(AuthorRequestDTO authorDTO);
    AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorDTO);
    void deleteAuthor(Long id);
}
