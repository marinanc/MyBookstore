package com.personalprojects.MyBookstore.repository;

import com.personalprojects.MyBookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // "LIKE %title%"
    List<Book> findByTitleContainingIgnoreCase(String title);

    /*
     * Search books by author and genres using id
     * findBy[name-of-attribute-in-book-model]_Id
     */
    List<Book> findByAuthors_Id(Long authorId);
    List<Book> findByGenres_Id(Long genreId);

    boolean existsByIsbnEbook(String isbnEbook);
    boolean existsByIsbnPrint(String isbnPrint);
}
