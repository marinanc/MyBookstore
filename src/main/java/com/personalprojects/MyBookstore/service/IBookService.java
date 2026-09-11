package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.BookDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> getBooks();
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}
