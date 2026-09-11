package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.GenreDTO;
import com.personalprojects.MyBookstore.model.Genre;

public class GenreMapper {
    public static GenreDTO toDTO(Genre genre) {
        if(genre == null) return null;

        return GenreDTO.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
