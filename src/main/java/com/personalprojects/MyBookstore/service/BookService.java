package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.BookRequestDTO;
import com.personalprojects.MyBookstore.dto.BookResponseDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.BookMapper;
import com.personalprojects.MyBookstore.model.*;
import com.personalprojects.MyBookstore.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class BookService implements IBookService{
    private final BookRepository repo;
    private final AuthorRepository authorRepo;
    private final GenreRepository genreRepo;
    private final PublisherRepository publisherRepo;
    private final SerieRepository serieRepo;
    private final SourceRepository sourceRepo;

    @Override
    public List<BookResponseDTO> getBooks() {
        return repo.findAll().stream().map(BookMapper::toResponseDTO).toList();
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookReqDTO) {
        Set<Author> bookAuthors = (bookReqDTO.getAuthorIds() != null
                && !bookReqDTO.getAuthorIds().isEmpty())
                ? new HashSet<>(authorRepo.findAllById(bookReqDTO.getAuthorIds()))
                : new HashSet<>();

        Set<Genre> bookGenres = (bookReqDTO.getGenreIds() != null
                && !bookReqDTO.getGenreIds().isEmpty())
                ? new HashSet<>(genreRepo.findAllById(bookReqDTO.getGenreIds()))
                : new HashSet<>();

        Publisher publisherBook = publisherRepo.findById(bookReqDTO.getIdPublisher()).orElse(null);
        Serie serieBook = serieRepo.findById(bookReqDTO.getIdSerie()).orElse(null);
        Source sourceBook = sourceRepo.findById(bookReqDTO.getIdSource()).orElse(null);

        // Map new book (RequestDTO) to entity
        Book book = BookMapper.toEntity(bookReqDTO, bookAuthors, bookGenres, publisherBook, serieBook, sourceBook);
        // Save the new book
        Book savedBook = repo.save(book);
        // Map saved book to DTO (ResponseDTO)
        return BookMapper.toResponseDTO(savedBook);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO bookReqDTO) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Libro no encontrado"));

        Set<Author> bookAuthors = (bookReqDTO.getAuthorIds() != null
                && !bookReqDTO.getAuthorIds().isEmpty())
                ? new HashSet<>(authorRepo.findAllById(bookReqDTO.getAuthorIds()))
                : new HashSet<>();

        Set<Genre> bookGenres = (bookReqDTO.getGenreIds() != null
                && !bookReqDTO.getGenreIds().isEmpty())
                ? new HashSet<>(genreRepo.findAllById(bookReqDTO.getGenreIds()))
                : new HashSet<>();

        Publisher publisherBook = publisherRepo.findById(bookReqDTO.getIdPublisher()).orElse(null);
        Serie serieBook = serieRepo.findById(bookReqDTO.getIdSerie()).orElse(null);
        Source sourceBook = sourceRepo.findById(bookReqDTO.getIdSource()).orElse(null);

        book.setTitle(bookReqDTO.getTitle());
        book.setIsbnEbook(bookReqDTO.getIsbnEbook());
        book.setIsbnPrint(bookReqDTO.getIsbnPrint());
        book.setPublishedYear(bookReqDTO.getPublishedYear());
        book.setPages(bookReqDTO.getPages());
        book.setSynopsis(bookReqDTO.getSynopsis());
        book.setLinkDownload(bookReqDTO.getLinkDownload());
        book.setVersion(bookReqDTO.getVersion());
        book.setAuthors(bookAuthors);
        book.setGenres(bookGenres);
        book.setPublisher(publisherBook);
        book.setSerie(serieBook);
        book.setSource(sourceBook);

        Book savedBook = repo.save(book);

        return BookMapper.toResponseDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Libro no encontrado");
        }

        repo.deleteById(id);
    }
}
