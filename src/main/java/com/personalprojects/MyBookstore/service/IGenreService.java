package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.GenreDTO;

import java.util.List;

public interface IGenreService {
    List<GenreDTO> getGenres();
    GenreDTO createGenre(GenreDTO genreDTO);
    GenreDTO updateGenre(Long id, GenreDTO genreDTO);
    void deleteGenre(Long id);
}
