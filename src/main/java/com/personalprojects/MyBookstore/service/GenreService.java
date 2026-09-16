package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.GenreDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.GenreMapper;
import com.personalprojects.MyBookstore.model.Genre;
import com.personalprojects.MyBookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenreService implements IGenreService{
    @Autowired
    private GenreRepository repo;

    @Override
    public List<GenreDTO> getGenres() {
        return repo.findAll().stream().map(GenreMapper::toDTO).toList();
    }

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        return GenreMapper.toDTO(repo.save(GenreMapper.toEntity(genreDTO)));
    }

    @Override
    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        Genre genre = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Género no encontrado"));
        genre.setName(genreDTO.getName());

        return GenreMapper.toDTO(repo.save(genre));

    }

    @Override
    public void deleteGenre(Long id) {
        if(!repo.existsById(id)) {
            throw new NotFoundException("Género no encontrado");
        }
        repo.deleteById(id);
    }
}
