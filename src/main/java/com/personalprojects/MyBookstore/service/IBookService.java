package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.BookRequestDTO;
import com.personalprojects.MyBookstore.dto.BookResponseDTO;

import java.util.List;
import java.util.Set;

public interface IBookService {
    List<BookResponseDTO> getBooks();
    BookResponseDTO createBook(BookRequestDTO bookReqDTO);
    BookResponseDTO updateBook(Long id, BookRequestDTO bookReqDTO);
    void deleteBook(Long id);
}
